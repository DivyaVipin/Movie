package assignment.android.acadgild.network;

import assignment.android.acadgild.utils.CommonUtilities;

/**
 * Created by DivyaVipin on 2/22/2017.
 */

public interface OnWebServiceResult {
    public void getWebResponse(String result, CommonUtilities.SERVICE_TYPE type);
}
