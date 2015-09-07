package it.jaschke.alexandria;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.jaschke.alexandria.camera.CameraPreview;


public class ScanBarcode extends Fragment {
    private OnScanBarcodeListener mListener;
    private CameraPreview mScanPreview;

    public static ScanBarcode newInstance() {
        ScanBarcode fragment = new ScanBarcode();
        return fragment;
    }

    public ScanBarcode() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_scan_barcode, container, false);
        mScanPreview = (CameraPreview) rootView.findViewById(R.id.scanPreviewPlaceholder);

        return rootView;
    }

    public void onBarcodeDecoded(String barcodeString) {
        if (mListener != null) {
            mListener.onBarcodeDecoded(barcodeString);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnScanBarcodeListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnScanBarcodeListener {
        public void onBarcodeDecoded(String barcodeString);
    }

}
