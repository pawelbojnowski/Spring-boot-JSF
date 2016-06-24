/**
 * (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pl.pb.web.spring.jsf.jsf.controllers;

import pl.pb.web.spring.jsf.reposytory.dao.ContactDao;
import pl.pb.web.spring.jsf.reposytory.model.ContactEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
//@Component
public class ContactBean implements Serializable {

    //    @Autowired
    //    ContactDao contactDao;

    //This approach requires Setter
    @ManagedProperty("#{contactDao}")
    ContactDao contactDao;

    ContactEntity contact;

    public List<ContactEntity> getContacts() {
        List<ContactEntity> contactEntities = (List<ContactEntity>) contactDao.findAll();
        return contactEntities;
    }

    public String createNew() {
        System.out.println("createNew()");
        contact = new ContactEntity();
        return "index.jsf";
    }

    public String edit() {
        Long id = new Long(getParam("id"));
        contact = contactDao.findOne(id);
        System.out.println(contact);
        return "index.jsf";
    }

    public String remove() {
        System.out.println("remove()");
        Long id = new Long(getParam("id"));
        if (contact != null && id.equals(contact.getId())) {
            contact = null;
        }
        contactDao.delete(id);
        return "index.jsf";
    }

    public String save() {
        System.out.println("save() ");
        contactDao.save(contact);
        contact = null;
        return "index.jsf";
    }

    public void saveAjax() {
        System.out.println("saveAjax()");
        save();
    }

    public String cancel() {
        System.out.println("cancel()");
        contact = null;
        return "index.jsf";
    }

    public String getParam(String param) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(param);
    }

    public ContactDao getContactDao() {
        return contactDao;
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
}
