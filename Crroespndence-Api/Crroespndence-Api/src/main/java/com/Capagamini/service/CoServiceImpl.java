package com.Capagamini.service;

import java.awt.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capagamini.binding.ElgResponse;
import com.Capagamini.entity.CitizenAppEntity;
import com.Capagamini.entity.CoTrgEntity;
import com.Capagamini.entity.DCCaseEntity;
import com.Capagamini.entity.EligibilityDeter;
import com.Capagamini.repository.CitizenAppRepsotory;
import com.Capagamini.repository.CoTrgRepository;
import com.Capagamini.repository.DcCaseRepository;
import com.Capagamini.repository.EligibilityRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class CoServiceImpl implements CoService{


	@Autowired
    private CoTrgRepository coTrgRepository;
	
	@Autowired
	private EligibilityRepository eligibilityRepository;
	
	@Autowired
	private DcCaseRepository dcCaseRepository;
	
	@Autowired
	private CitizenAppRepsotory citizenAppRepsotory;
	
//	@Autowired
//	private RedisTemplate<String , String> redisTemplate;

    @Override
    public ElgResponse processPendingTriggers() throws Exception{
    	
//    	HashOperations<String, Object, Object> hashOps = redisTemplate.opsForHash();
//
//    	String addr = (String) hashOps.get("DHS", "DHS_OFFICE ADDRESS");
    	
//    	String[] addrToken = addr.split("#");
//    	
//    	String hno=addrToken[0];
//    	
//    	String street =addrToken[1];
//    	
//    	String city =addrToken[2];
//    	
//    	String phno=addrToken[3];
    	
        final Long failed = 1L;
        final Long success = 1L;

        ElgResponse response = new ElgResponse();
        
        List<CoTrgEntity> pendingTig = coTrgRepository.findByTrgStatus("Pending");

        ExecutorService exservice=Executors.newFixedThreadPool(10);
        
        for (CoTrgEntity trigger : pendingTig) {
        	
        	exservice.submit(new Callable<Object>() {
        		
        		@Override
        		public Object call() throws Exception {
        			 processTriggers(response, trigger);
        			 return null;
        		}
			});
           
        }

        response.setTotalTriggers((Long.valueOf( pendingTig.size())));
        response.setSuccTriggers(success);
        response.setFailedTriggers(failed);
        return response;
    }
    
    
    

    private CitizenAppEntity processTriggers(ElgResponse response, CoTrgEntity entity)throws Exception{
        
    	CitizenAppEntity appEntity=null;
    	
    	EligibilityDeter elig = eligibilityRepository.findByCaseNum(entity.getCaseNum());
    	
    	
    	Optional<DCCaseEntity> findById = dcCaseRepository.findById(entity.getCaseNum());
    	
    	if(findById.isPresent()) {
    		
    		DCCaseEntity dcCaseEntity=findById.get();
    		
    		Integer appId = dcCaseEntity.getAppId();
    		
			Optional<CitizenAppEntity> appEntityOptional = citizenAppRepsotory.findById(appId);
			
			if(appEntityOptional.isPresent()) {
				appEntity=appEntityOptional.get();
		
		
			}
    	}
    	genrateAndsendPdf(elig,appEntity);
    	
		return appEntity;	
    }
    
    public void genrateAndsendPdf(EligibilityDeter elgData,CitizenAppEntity appEntity) throws Exception {
    	
    	Document document = new Document(PageSize.A4);
    	
    	File file=new File(elgData.getCaseNum() +".pdf");
    	
    	FileOutputStream fos=null;
    	
    	try {
			fos=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	 PdfWriter.getInstance(document,fos);
    	 
    	 document.open();
    	 
    	 Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
         font.setSize(18);
         font.setColor(Color.BLUE);
         
         Paragraph p = new Paragraph("Eligibility Report !!", font);
         p.setAlignment(Paragraph.ALIGN_CENTER);
         
         document.add(p);
         
         PdfPTable table = new PdfPTable(8);
         table.setWidthPercentage(100f);
         table.setWidths(new float[] {3.0f, 3.5f, 3.0f, 3.0f, 3.5f,3.0f,3.0f,2.5f});
         table.setSpacingBefore(12);
         
         PdfPCell cell = new PdfPCell();
         cell.setBackgroundColor(Color.BLUE);
         cell.setPadding(8);
         
         font =FontFactory.getFont(FontFactory.HELVETICA);
         font.setColor(Color.WHITE);
         
          
         cell.setPhrase(new Phrase("Citizen Name", font));
         table.addCell(cell);
         
         cell.setPhrase(new Phrase("Plan name", font));
         table.addCell(cell);
          
         cell.setPhrase(new Phrase("Plan Status", font));
         table.addCell(cell);
          
         cell.setPhrase(new Phrase("Plan start Date", font));
         table.addCell(cell);
          
         cell.setPhrase(new Phrase("Plan And End Date", font));
         table.addCell(cell); 
         
         cell.setPhrase(new Phrase("Benefit Amount", font));
         table.addCell(cell); 
         
         cell.setPhrase(new Phrase("Denail Reason", font));
         table.addCell(cell); 
         
         table.addCell(appEntity.getFullName());
         table.addCell(appEntity.getPlanName());
         table.addCell(appEntity.getPlanStartdate() +"");
         table.addCell(appEntity.getPlanEndDate() +"");
         table.addCell(appEntity.getPlanstatus()+ "");
         table.addCell(appEntity.getDenailReason() + "");
         
         
         //get footer data and write pdf
         
//         String[] addrToken = footer.split("#");
//
//     	String hno=addrToken[0];
//
//     	String street =addrToken[1];
//
//     	String city =addrToken[2];
//
//     	String phno=addrToken[3];
//
//     	String email=addrToken[4];
//
//     	String website=addrToken[5];
//
//     	String footerText="H.No :"+hno+"Street :"+street+"City :"+city+"PhNo :"+phno+
//     			"Email :"+email+"Website :"+website;
//
//     	Paragraph footerp = new Paragraph(footerText, font);
//
//     	document.add(footerp);
         
         document.add(table);
         
         document.close();
         
         String subject="His Eligibility Info";
         
         String body="His Eligibility Info";
         
         updateTrigger(elgData.getCaseNum(),file);
         
         file.delete();
         
    	
    }
    
    	public void updateTrigger(Long caseNum,File file) throws Exception {
    		
    		CoTrgEntity coEntity = coTrgRepository.findByCaseNum(caseNum);
		
    		byte[] arr=new byte[(int) file.length()];
    		
    		FileInputStream fis=new FileInputStream(file);
    		
    		fis.read(arr);
    		
    		coEntity.setPdf(arr);
    		
    		coEntity.setTrgStatus("Completed !!");
    		
    		coTrgRepository.save(coEntity);
    		
    		fis.close();
    	}

}
