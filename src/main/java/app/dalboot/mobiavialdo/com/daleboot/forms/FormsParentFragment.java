package app.dalboot.mobiavialdo.com.daleboot.forms;

import android.support.v4.app.Fragment;

/**
 * Author: Muhammad Uzair
 * Date: 7/14/17.
 * Description: It is base class for all profile fragment that contain necessary things for fragments
 */

public class FormsParentFragment extends Fragment {
    protected String[]upperspinner_items=new String[]{"NEVER","LEFT","RIGHT","BOTH"};
    protected String[]ability_level_items=new String[]{"NOVICE","INTERMEDIATE","EXPERT","RACER"};
    protected String[]att_sking_items=new String[]{"TENSED","RELAXED","AGGRESSIVE"};
    protected String[]prefered_sking_items=new String[]{"GROOMERS","POWDER","MOGULS","FLAT","AVERAGE","STEEP"};
    protected String []heel_stance_items=new String[]{"NORMAL","PRONATION","SUPINATION"};
    protected String[]ankle_items=new String[]{"NORMAL","LARGE MEDIAL","LARGE LATERAL"};
    protected String[]exostosis_items=new String[]{"INSTEP BUMP","HALLUX VALGUS","TAILOR'S BUNION","PUMP BUMP","BUNION","MORTON'S FOOT","OTHER"};
    protected String[]forbed_items=new String[]{"YES","NO","TYPE","REBUILD"};
    protected String[]tools_measures_items=new String[]{"BRANNOCK","MONDO"};
    protected String[]default_items=new String[]{"YES","NO"};
    protected String[] models_selection=new String[]{"VFF","VFF PRO","AK 130"};
    protected String[] liner_types=new String[]{"WRAP","TONGUE","PLUSH"};
    protected String us_metric="in";




    /**
     * @usage This method cast the activity object with the desired object
     *        provided by the caller in order to get specified activity
     *        instead of general object.
     * @param service
     * @param <T>
     * @return
     */
    public <T>T getActualActivity(Class<T> service)
    {
        return (T)getActivity();
    }
}
