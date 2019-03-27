package org.linphone.settings;

/*
NewSettingsFragment.java
Copyright (C) 2019 Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import org.linphone.LinphoneActivity;
import org.linphone.R;
import org.linphone.fragments.FragmentsAvailable;

public class NewSettingsFragment extends Fragment {
    protected View mRootView;
    private BasicSetting mTunnel, mAudio, mVideo, mCall, mChat, mNetwork, mAdvanced;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.new_settings, container, false);

        loadSettings();
        setListeners();

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (LinphoneActivity.isInstanciated()) {
            LinphoneActivity.instance().selectMenu(FragmentsAvailable.SETTINGS);
        }

        updateValues();
    }

    protected void loadSettings() {
        mTunnel = mRootView.findViewById(R.id.pref_tunnel);
        mAudio = mRootView.findViewById(R.id.pref_audio);
        mVideo = mRootView.findViewById(R.id.pref_video);
        mCall = mRootView.findViewById(R.id.pref_call);
        mChat = mRootView.findViewById(R.id.pref_chat);
        mNetwork = mRootView.findViewById(R.id.pref_network);
        mAdvanced = mRootView.findViewById(R.id.pref_advanced);
    }

    protected void setListeners() {
        mAudio.setListener(
                new SettingListenerBase() {
                    @Override
                    public void onClicked() {
                        LinphoneActivity.instance().displaySubSettings(new AudioSettingsFragment());
                    }
                });
        // TODO
    }

    protected void updateValues() {
        // TODO

        initAccounts();
    }

    private void initAccounts() {}
}
