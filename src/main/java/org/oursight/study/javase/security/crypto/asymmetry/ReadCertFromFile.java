package org.oursight.study.javase.security.crypto.asymmetry;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class ReadCertFromFile {
	
	public static void main(String[] args) throws Exception {
	    FileInputStream fis = new FileInputStream("/Users/yaonengjun/Dev/Java/eclipse_workspace/TRS/TRSIDS_Trunk/tools/ca/test.cer");
	    BufferedInputStream bis = new BufferedInputStream(fis);
	    
	    CertificateFactory cf = CertificateFactory.getInstance("X.509");
	    while(bis.available()>0) {
	    	Certificate cert = cf.generateCertificate(bis);
	    	System.out.println(cert.toString());
	    	System.out.println("----------------");
	    	System.out.println("public key: ");
	    	System.out.println(cert.getPublicKey());
	    	System.out.println();
	    	
	    	System.out.println("type: ");
	    	System.out.println(cert.getType());
	    	System.out.println();
	    }
    }

}
