package app.dalboot.mobiavialdo.com.daleboot.models.request;

/**
 * Author: Uzair Qureshi
 * Date:  10/3/17.
 * Description:
 */

public class Customer {
    private static Customer mInstance;
    private String first_name;
    private String last_name;
    private String street;
    private String occupation;
    private String tel;
    private String city;
    private String state;
    private String zip_code;
    private String email;
    private String bone_discomfort;
    private String shin_bang;
    private String your_feets;
    private String ski_boots;
    private String ability_level;
    private String attitude_while_skiing;
    private String skiing_condition;
    private String height;
    private String weight;
    private String street_shoe_size;
    private String arch_height;
    private String heel_stance;
    private String ankle_select;
    private String doorflexion;
    private String exostosis;
    private String difference_leg_length;
    private String foot_bed;
    private String windlass;
    private String forefoot;
    private String rom;
    private String calf;
    private String ankle;
    private String foot_volue;
    private String width;
    private String measurement_below;
    private String size;
    private String arch_length;
    private String model_selection;
    private String  size_select;
    private String liner_size;
    private String liner_type;
    private String saleman_name;
    private String deposit;
    private String pick_date;
    private String amount;
    private String  invoice_number;


    private String prev_brand;
    private String prev_brand_model;
    private String prev_brand_year;
    private String prev_brand_size;
    private String prev_brand_sole_length;
    private String Comments;
    private String years_skiing;
    private String avg_ski_days;
    private String Observations;


    public String getPrev_brand() {
        return prev_brand;
    }

    public void setPrev_brand(String prev_brand) {
        this.prev_brand = prev_brand;
    }


    public String getPrev_brand_model() {
        return prev_brand_model;
    }

    public void setPrev_brand_model(String prev_brand_model) {
        this.prev_brand_model = prev_brand_model;
    }

    public String getPrev_brand_year() {
        return prev_brand_year;
    }

    public void setPrev_brand_year(String prev_brand_year) {
        this.prev_brand_year = prev_brand_year;
    }

    public String getPrev_brand_size() {
        return prev_brand_size;
    }

    public void setPrev_brand_size(String prev_brand_size) {
        this.prev_brand_size = prev_brand_size;
    }

    public String getPrev_brand_sole_length() {
        return prev_brand_sole_length;
    }

    public void setPrev_brand_sole_length(String prev_brand_sole_length) {
        this.prev_brand_sole_length = prev_brand_sole_length;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getYears_skiing() {
        return years_skiing;
    }

    public void setYears_skiing(String years_skiing) {
        this.years_skiing = years_skiing;
    }

    public String getAvg_ski_days() {
        return avg_ski_days;
    }

    public void setAvg_ski_days(String avg_ski_days) {
        this.avg_ski_days = avg_ski_days;
    }

    public String getObservations() {
        return Observations;
    }

    public void setObservations(String observations) {
        Observations = observations;
    }


    /**
     * private constructor
     */
    private Customer(){

    }
    public static Customer getInstance(){
        if(mInstance==null){
            mInstance=new Customer();
        }
        return mInstance;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPick_date() {
        return pick_date;
    }

    public void setPick_date(String pick_date) {
        this.pick_date = pick_date;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getSaleman_name() {
        return saleman_name;
    }

    public void setSaleman_name(String saleman_name) {
        this.saleman_name = saleman_name;
    }

    public String getLiner_type() {
        return liner_type;
    }

    public void setLiner_type(String liner_type) {
        this.liner_type = liner_type;
    }

    public String getLiner_size() {
        return liner_size;
    }

    public void setLiner_size(String liner_size) {
        this.liner_size = liner_size;
    }

    public String getSize_select() {
        return size_select;
    }

    public void setSize_select(String size_select) {
        this.size_select = size_select;
    }

    public String getModel_selection() {
        return model_selection;
    }

    public void setModel_selection(String model_selection) {
        this.model_selection = model_selection;
    }

    public String getArch_length() {
        return arch_length;
    }

    public void setArch_length(String arch_length) {
        this.arch_length = arch_length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMeasurement_below() {
        return measurement_below;
    }

    public void setMeasurement_below(String measurement_below) {
        this.measurement_below = measurement_below;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getFoot_volue() {
        return foot_volue;
    }

    public void setFoot_volue(String foot_volue) {
        this.foot_volue = foot_volue;
    }

    public String getAnkle() {
        return ankle;
    }

    public void setAnkle(String ankle) {
        this.ankle = ankle;
    }

    public String getCalf() {
        return calf;
    }

    public void setCalf(String calf) {
        this.calf = calf;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getForefoot() {
        return forefoot;
    }

    public void setForefoot(String forefoot) {
        this.forefoot = forefoot;
    }

    public String getWindlass() {
        return windlass;
    }

    public void setWindlass(String windlass) {
        this.windlass = windlass;
    }

    public String getFoot_bed() {
        return foot_bed;
    }

    public void setFoot_bed(String foot_bed) {
        this.foot_bed = foot_bed;
    }

    public String getDifference_leg_length() {
        return difference_leg_length;
    }

    public void setDifference_leg_length(String difference_leg_length) {
        this.difference_leg_length = difference_leg_length;
    }

    public String getExostosis() {
        return exostosis;
    }

    public void setExostosis(String exostosis) {
        this.exostosis = exostosis;
    }

    public String getDoorflexion() {
        return doorflexion;
    }

    public void setDoorflexion(String doorflexion) {
        this.doorflexion = doorflexion;
    }

    public String getAnkle_select() {
        return ankle_select;
    }

    public void setAnkle_select(String ankle_select) {
        this.ankle_select = ankle_select;
    }

    public String getHeel_stance() {
        return heel_stance;
    }

    public void setHeel_stance(String heel_stance) {
        this.heel_stance = heel_stance;
    }

    public String getArch_height() {
        return arch_height;
    }

    public void setArch_height(String arch_height) {
        this.arch_height = arch_height;
    }

    public String getStreet_shoe_size() {
        return street_shoe_size;
    }

    public void setStreet_shoe_size(String street_shoe_size) {
        this.street_shoe_size = street_shoe_size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSkiing_condition() {
        return skiing_condition;
    }

    public void setSkiing_condition(String skiing_condition) {
        this.skiing_condition = skiing_condition;
    }

    public String getAttitude_while_skiing() {
        return attitude_while_skiing;
    }

    public void setAttitude_while_skiing(String attitude_while_skiing) {
        this.attitude_while_skiing = attitude_while_skiing;
    }

    public String getAbility_level() {
        return ability_level;
    }

    public void setAbility_level(String ability_level) {
        this.ability_level = ability_level;
    }

    public String getSki_boots() {
        return ski_boots;
    }

    public void setSki_boots(String ski_boots) {
        this.ski_boots = ski_boots;
    }

    public String getYour_feets() {
        return your_feets;
    }

    public void setYour_feets(String your_feets) {
        this.your_feets = your_feets;
    }

    public String getShin_bang() {
        return shin_bang;
    }

    public void setShin_bang(String shin_bang) {
        this.shin_bang = shin_bang;
    }

    public String getBone_discomfort() {
        return bone_discomfort;
    }

    public void setBone_discomfort(String bone_discomfort) {
        this.bone_discomfort = bone_discomfort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }



    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

}
