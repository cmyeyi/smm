package com.can.mz.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.can.mz.R;
import com.can.mz.base.BaseFragment;

import java.io.File;
import java.lang.reflect.Field;

import static android.app.Activity.RESULT_OK;

public class UcropFragment extends BaseFragment{

    public static final int LOAD_IMAGES_RESULT = 0x01;
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 0x02;
    private static final String CROPPED_IMAGE_NAME = ".png";
    private View mRootView;
    private Button toPicturesView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.layout_fragment_ucrop, container, false);
        }
        initView();
        return mRootView;
    }



    private void initView() {
        if(mRootView != null) {
            toPicturesView = mRootView.findViewById(R.id.id_smm_crop);
        }
        initListeners();
    }

    private void initListeners() {
        if(toPicturesView != null) {
            toPicturesView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadLocateImages();
                }
            });
        }
    }

    private void loadLocateImages() {
        Uri imageURI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (imageURI != null) {
            try {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_STORAGE_READ_ACCESS_PERMISSION);
                } else {
                    Intent intent = new Intent(Intent.ACTION_PICK, imageURI);
                    getActivity().startActivityForResult(intent, LOAD_IMAGES_RESULT);
                }
            } catch (Exception e) {
                Log.w("PersonalEditPresenter", "loadImages: " + e.getMessage());
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == LOAD_IMAGES_RESULT) {
//            if (resultCode == RESULT_OK && data != null) {
//                Uri selectedImage = data.getData();
//                startCrop(selectedImage);
//            }
//        } else if (requestCode == UCrop.REQUEST_CROP && resultCode == RESULT_OK) {
//            mCropUri = UCrop.getOutput(data);
//            mCropPicPath = mCropUri.getPath();
//            mPage.bindImageToAvatarAfterCrop(mCropUri);
//        }

    }

    private void startCrop(@NonNull Uri uri) {

//        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getActivity().getCacheDir(), System.currentTimeMillis() + CROPPED_IMAGE_NAME)));
//        UCrop.Options options = new UCrop.Options();
//        options.setCompressionQuality(50);
//        uCrop.withOptions(options);
//        uCrop.start(mActivity);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
