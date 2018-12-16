package tn.enig.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enig.model.Utilisateur;

@Repository
public interface IUserDao extends CrudRepository<Utilisateur, Integer> {

	public List<Utilisateur> findByUsernameAndPassword(String x1, String x2);
}
