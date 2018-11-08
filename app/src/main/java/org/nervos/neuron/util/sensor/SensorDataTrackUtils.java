package org.nervos.neuron.util.sensor;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

import org.json.JSONException;
import org.json.JSONObject;
import org.nervos.neuron.constant.SensorDataCons;

/**
 * Created by BaojunCZ on 2018/10/10.
 */
public class SensorDataTrackUtils {

    public static void transferAccount(String symbol, String value, String receiver, String sender, String chain, String type) {
        try {
            JSONObject object = new JSONObject();
            object.put(SensorDataCons.INSTANCE.getTAG_TRANSFER_TARGET_CURRENCY(), symbol);
            object.put(SensorDataCons.INSTANCE.getTAG_TRANSFER_TARGET_CURRENCY_NUMBER(), value);
            object.put(SensorDataCons.INSTANCE.getTAG_TRANSFER_RECEIVE_ADDRESS(), receiver);
            object.put(SensorDataCons.INSTANCE.getTAG_TRANSFER_OUTCOME_ADDRESS(), sender);
            object.put(SensorDataCons.INSTANCE.getTAG_TRANSFER_TRANSFER_TYPE(), type);
            object.put(SensorDataCons.INSTANCE.getTAG_TRANSFER_TARGET_CHAIN(), chain);
            SensorsDataAPI.sharedInstance().track(SensorDataCons.INSTANCE.getTRACK_TRANSFER_ACCOUNTS(), object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
