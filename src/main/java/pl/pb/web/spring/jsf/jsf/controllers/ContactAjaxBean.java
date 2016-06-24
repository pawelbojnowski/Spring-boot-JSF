package pl.pb.web.spring.jsf.jsf.controllers;

import pl.pb.web.spring.jsf.reposytory.dao.ContactDao;
import pl.pb.web.spring.jsf.reposytory.model.ContactEntity;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
//@Component
public class ContactAjaxBean implements Serializable {

    public ContactDao getContactDao() {
        return contactDao;
    }

    //    @Autowired
    //    ContactDao contactDao;

    //This approach requires Setter
    @ManagedProperty("#{contactDao}")
    ContactDao contactDao;

    ContactEntity contact;
    Long idContact;

    public List<ContactEntity> getContacts() {
        List<ContactEntity> contactEntities = (List<ContactEntity>) contactDao.findAll();
        return contactEntities;
    }

    public void createNew() {
        System.out.println("createNew()");
        contact = new ContactEntity();
    }

    public void edit() {
        System.out.println("edit()");
        contact = contactDao.findOne(idContact);
        System.out.println(contact);
    }

    public void remove() {
        System.out.println("edit()");
        if (contact != null && idContact.equals(contact.getId())) {
            contact = null;
        }
        contactDao.delete(idContact);
        System.out.println(contact);
    }

    public void save() {
        System.out.println("save()");
        contactDao.save(contact);
        contact = null;
    }

    public void cancel() {
        System.out.println("cancel()");
        contact = null;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }
}
