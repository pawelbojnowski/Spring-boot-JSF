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

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class OtherBean implements Serializable {

    private String exampleValue;
    private String email;
    private Date date;
    private List<String> listOfValue = Arrays.asList("Java", "Spring boot", "JSF");
    private String selectedValue;
    private String ccTest1;
    private String ccTest2;

    public String getExampleValue() {
        return exampleValue;
    }

    public void setExampleValue(String exampleValue) {
        this.exampleValue = exampleValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getListOfValue() {
        return listOfValue;
    }

    public void setListOfValue(List<String> listOfValue) {
        this.listOfValue = listOfValue;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String getCcTest1() {
        return ccTest1;
    }

    public void setCcTest1(String ccTest1) {
        this.ccTest1 = ccTest1;
    }

    public String getCcTest2() {
        return ccTest2;
    }

    public void setCcTest2(String ccTest2) {
        this.ccTest2 = ccTest2;
    }
}
