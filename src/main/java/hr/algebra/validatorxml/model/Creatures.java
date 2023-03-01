//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.02.27 at 09:11:47 PM CET 
//


package hr.algebra.validatorxml.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creature" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="creatureName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="aboutCreature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="groupType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="diet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="temperament" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="urlIcon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="urlImage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="audio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "creature"
})
@XmlRootElement(name = "creatures")
public class Creatures {

    @XmlElement(required = true)
    protected List<Creatures.Creature> creature;

    /**
     * Gets the value of the creature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Creatures.Creature }
     * 
     * 
     */
    public List<Creatures.Creature> getCreature() {
        if (creature == null) {
            creature = new ArrayList<Creatures.Creature>();
        }
        return this.creature;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="creatureName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="aboutCreature" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="groupType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="diet" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="temperament" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="urlIcon" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="urlImage" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="audio" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "creatureName",
        "aboutCreature",
        "groupType",
        "diet",
        "temperament",
        "urlIcon",
        "urlImage",
        "audio"
    })
    public static class Creature {

        @XmlElement(required = true)
        protected String creatureName;
        @XmlElement(required = true)
        protected String aboutCreature;
        @XmlElement(required = true)
        protected String groupType;
        @XmlElement(required = true)
        protected String diet;
        @XmlElement(required = true)
        protected String temperament;
        @XmlElement(required = true)
        protected String urlIcon;
        @XmlElement(required = true)
        protected String urlImage;
        @XmlElement(required = true)
        protected String audio;

        /**
         * Gets the value of the creatureName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCreatureName() {
            return creatureName;
        }

        /**
         * Sets the value of the creatureName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCreatureName(String value) {
            this.creatureName = value;
        }

        /**
         * Gets the value of the aboutCreature property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAboutCreature() {
            return aboutCreature;
        }

        /**
         * Sets the value of the aboutCreature property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAboutCreature(String value) {
            this.aboutCreature = value;
        }

        /**
         * Gets the value of the groupType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGroupType() {
            return groupType;
        }

        /**
         * Sets the value of the groupType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGroupType(String value) {
            this.groupType = value;
        }

        /**
         * Gets the value of the diet property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDiet() {
            return diet;
        }

        /**
         * Sets the value of the diet property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDiet(String value) {
            this.diet = value;
        }

        /**
         * Gets the value of the temperament property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTemperament() {
            return temperament;
        }

        /**
         * Sets the value of the temperament property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemperament(String value) {
            this.temperament = value;
        }

        /**
         * Gets the value of the urlIcon property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUrlIcon() {
            return urlIcon;
        }

        /**
         * Sets the value of the urlIcon property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUrlIcon(String value) {
            this.urlIcon = value;
        }

        /**
         * Gets the value of the urlImage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUrlImage() {
            return urlImage;
        }

        /**
         * Sets the value of the urlImage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUrlImage(String value) {
            this.urlImage = value;
        }

        /**
         * Gets the value of the audio property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAudio() {
            return audio;
        }

        /**
         * Sets the value of the audio property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAudio(String value) {
            this.audio = value;
        }

        @Override
        public String toString() {
            return "Creature{" +
                    "creatureName='" + creatureName + '\''
                    ;
        }
    }

}
