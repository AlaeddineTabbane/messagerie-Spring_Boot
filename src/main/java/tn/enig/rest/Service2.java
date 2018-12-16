package tn.enig.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IMessageDao;
import tn.enig.dao.IUserDao;
import tn.enig.model.Message;
import tn.enig.model.Utilisateur;

@CrossOrigin("*")
@RestController
@RequestMapping("/boite")
public class Service2 {
	
	@Autowired
	IMessageDao mdao;
	@Autowired
	IUserDao udao;
	
	public void setMdao(IMessageDao mdao) {	this.mdao = mdao;}
	public void setUdao(IUserDao udao) {this.udao = udao;}
	
	@GetMapping("/verif/{username}/{password}")
	public List<Utilisateur> verif(@PathVariable("username") String s1, @PathVariable("password") String s2){
		return udao.findByUsernameAndPassword(s1,s2);
	}
	
	@GetMapping("/utilisateurs")
	public List<Utilisateur> users(){
		return (List<Utilisateur>) udao.findAll();
	}
	
	@GetMapping("/utilisateur/{id}")
	public Optional<Utilisateur> user1(@PathVariable("id") int id){
		return  udao.findById(id);
	}
	
	@GetMapping("/messagesrecus/{id}")
	public List<Message> messagesrecu(@PathVariable("id") int id){
		return mdao.getTousLesMessagesRecus(id);
	}
	
	@GetMapping("/messagesenvoyes/{id}")
	public List<Message> messagesenvoyes(@PathVariable("id") int id){
		return mdao.getTousLesMessagesEnvoyes(id);
	}
	
	@GetMapping("/message/{id}")
	public Optional<Message> messageById(@PathVariable("id") int id){
		return mdao.findById(id);
	}
	
	@PostMapping("/addMessage")
	public void addMessage(@RequestBody Message m1) {
		 mdao.save(m1);
	}
	
	@DeleteMapping("/delMessage/{id}")
	public void delMessage(@PathVariable("id") int id) {
		 mdao.deleteById(id);
	}

}
