package br.ufc.petti.certificadosflisol.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import br.ufc.petti.certificadosflisol.entity.Participante;

public class SendEmail {

	private static String hostName = "smtp.gmail.com";
	private static String from = "petccqx@gmail.com";
	private static String password = "891338-891430";
	private static String fromName = "PET - Tecnologia da Informação";
	private static String subject = "Certificado - FLISoL Quixadá 2017";
	private static String msg = "Obrigado por participar do FLISoL Quixadá 2017! :D";
	
	public static void sendEmail(Participante participante, String pathToFile) throws EmailException{
		
		EmailAttachment attachement = new EmailAttachment();
		attachement.setPath(pathToFile);
		attachement.setDisposition(EmailAttachment.ATTACHMENT);
		attachement.setName("Certificado.jpg");
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(hostName);
		email.setAuthenticator(new DefaultAuthenticator(from, password));
		email.setSSLOnConnect(true);
		email.addTo(participante.getEmail(), participante.getNome());
		email.setFrom(from, fromName);
		email.setSubject(subject);
		email.setMsg(msg);
		
		email.attach(attachement);
		
		email.send();
		
	}
	
}
