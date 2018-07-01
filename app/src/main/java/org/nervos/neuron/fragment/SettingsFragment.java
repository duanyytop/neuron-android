package org.nervos.neuron.fragment;

import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.nervos.neuron.R;
import org.nervos.neuron.activity.SimpleWebActivity;
import org.nervos.neuron.util.ConstantUtil;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingsFragment extends Fragment {

    public static final String TAG = SettingsFragment.class.getName();

    private TextView contactText;
    private CircleImageView appImage;
    private TextView versionText;
    private TextView sourceCodeText;
    private TextView protocolText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        contactText = view.findViewById(R.id.setting_contact);
        appImage = view.findViewById(R.id.app_photo);
        versionText = view.findViewById(R.id.app_version);
        sourceCodeText = view.findViewById(R.id.setting_source_code);
        protocolText = view.findViewById(R.id.service_protocol);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initListener();
    }

    private void initListener() {

        appImage.setImageResource(R.mipmap.ic_launcher);

        try {
            String versionName = getContext().getPackageManager()
                    .getPackageInfo(getContext().getPackageName(), 0).versionName;
            versionText.setText(String.format("V %s", versionName));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        sourceCodeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleWebActivity.gotoSimpleWeb(getContext(), ConstantUtil.SOURCE_CODE_GITHUB_URL);
            }
        });

        protocolText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleWebActivity.gotoSimpleWeb(getContext(), ConstantUtil.PRODUCT_AGREEMENT_URL);
            }
        });

        contactText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleWebActivity.gotoSimpleWeb(getContext(), ConstantUtil.CONTACT_US_RUL);
            }
        });

    }
}
