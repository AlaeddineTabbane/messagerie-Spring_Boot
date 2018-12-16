package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enig.model.Message;

@Repository
public interface IMessageDao extends CrudRepository<Message, Integer>{

	@Query("select m from Message m where m.userreceive.id=:x")
	public List<Message> getTousLesMessagesRecus(@Param("x") int id);
	
	@Query("select m from Message m where m.usersend.id=:x")
	public List<Message> getTousLesMessagesEnvoyes(@Param("x") int id);
}
