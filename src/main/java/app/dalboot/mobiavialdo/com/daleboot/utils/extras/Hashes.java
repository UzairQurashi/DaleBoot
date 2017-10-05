package app.dalboot.mobiavialdo.com.daleboot.utils.extras;

import java.util.HashMap;
import java.util.Map;

import app.dalboot.mobiavialdo.com.daleboot.models.request.Customer;

/**
 * Author: Uzair Qureshi
 * Date:  10/3/17.
 * Description:
 */

public class Hashes {
    public static Map<String, String> getCustomerKey(Customer customer) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("first_name", customer.getFirst_name());
        hashMap.put("last_name", customer.getLast_name());
        hashMap.put("street", customer.getStreet());
        hashMap.put("occupation", customer.getOccupation());
        hashMap.put("tel", customer.getTel());
        hashMap.put("city", customer.getCity());
        hashMap.put("state", customer.getState());
        hashMap.put("zip_code", customer.getZip_code());
        hashMap.put("email", customer.getEmail());
        hashMap.put("bone_discomfort", customer.getBone_discomfort());
        hashMap.put("shin_bang", customer.getShin_bang());
        hashMap.put("your_feets", customer.getYour_feets());
        hashMap.put("ski_boots", customer.getSki_boots());
        hashMap.put("ability_level", customer.getAbility_level());
        hashMap.put("attitude_while_skiing", customer.getAttitude_while_skiing());
        hashMap.put("skiing_condition", customer.getSkiing_condition());
        hashMap.put("height", customer.getHeight());
        hashMap.put("weight", customer.getWeight());
        hashMap.put("street_shoe_size", customer.getStreet_shoe_size());
        hashMap.put("arch_height", customer.getArch_height());
        hashMap.put("heel_stance", customer.getHeel_stance());
        hashMap.put("ankle_select", customer.getAnkle_select());
        hashMap.put("doorflexion", customer.getDoorflexion());
        hashMap.put("exostosis", customer.getExostosis());
        hashMap.put("difference_leg_length", customer.getDifference_leg_length());
        hashMap.put("foot_bed", customer.getFoot_bed());
        hashMap.put("windlass", customer.getWindlass());
        hashMap.put("forefoot", customer.getForefoot());
        hashMap.put("rom", customer.getRom());
        hashMap.put("calf", customer.getCalf());
        hashMap.put("ankle", customer.getAnkle());
        hashMap.put("width", customer.getWidth());
        hashMap.put("foot_volue", customer.getFoot_volue());
        hashMap.put("measurement_below", customer.getMeasurement_below());
        hashMap.put("size", customer.getSize());
        hashMap.put("arch_length", customer.getArch_length());
        hashMap.put("model_selection", customer.getArch_height());
        hashMap.put("size_select", customer.getSize_select());
        hashMap.put("liner_size", customer.getLiner_size());
        hashMap.put("liner_type", customer.getLiner_type());//douth
        hashMap.put("pick_date", customer.getPick_date());
        hashMap.put("amount", customer.getAmount());
        hashMap.put("invoice_number", customer.getInvoice_number());

        return hashMap;

    }
}
