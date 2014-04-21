/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl;

import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author DickD
 */
@Model
public class NewJSFManagedBean {

  String message;
  String label = "Type je bericht:";

  @Inject
  NewSessionBean newSessionBean;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }



  /**
   * Creates a new instance of NewJSFManagedBean
   */
  public NewJSFManagedBean() {
  }

  public void save() {
    System.out.println("New message: "+ message);
    newSessionBean.saveMessage(message);
  }

  public List<Message> getMessages() {
    return newSessionBean.getAllMessages();
  }

}
