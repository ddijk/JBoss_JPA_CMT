/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DickD
 */
@Stateless
public class NewSessionBean {

    // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")
  @PersistenceContext(name = "JBossDatasourcePU")
  EntityManager em;

  public void saveMessage(String tekst) {

    Message msg = new Message();
    msg.setTekst(tekst);
    em.persist(msg);
    System.out.println("message persisted");
  }

  public List<Message> getAllMessages() {
    return em.createQuery("Select m from Message m", Message.class).getResultList();
  }
}
