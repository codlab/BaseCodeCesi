/**
 * Created by Pauly Jenkins on 26/06/2017.
 */
package fr.cesi.bar.map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cesi.bar.form.UserFormActivity;
import fr.cesi.base.database.Bar;
import fr.cesi.base.database.BarController;
import fr.cesi.basecode.R;

import static fr.cesi.basecode.R.id.title;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private View mBottomSheet;
    private BottomSheetLayout mBottomSheetLayout;

    @BindView(R.id.bar_name)
    public TextView mBarName;

    @BindView(R.id.price_max)
    public TextView mPriceMax;

    @BindView(R.id.price_min)
    public TextView mPriceMin;

    List<Bar> mBars;
    HashMap<Marker, Bar> mMarkerBars = new HashMap<>();
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        FlowManager.init(this);

        mBottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottom_sheet);

        mBottomSheet = LayoutInflater.from(this)
                .inflate(R.layout.view_bottom_sheet, mBottomSheetLayout, false);


        //we load the views from mBottomSHeet into the @BindView
        //ButterKnife.bind(this, mBottomSheet);
    }


    @Override
    protected void onResume() {
        super.onResume();


        int access_fine_location = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int access_coarce_location = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if (access_coarce_location != PackageManager.PERMISSION_GRANTED ||
                access_fine_location != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    1337); //here, request callback int to 1337 - used when manage response from call
        } else {
            //here we can manage maps start
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);

            mapFragment.getMapAsync(this);

            init();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        init();

        mMap.setMyLocationEnabled(true);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                onMarkerClickListener(marker);
                // return false;
                return true;
            }
        });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                UserFormActivity.startUserFormActivity(MapsActivity.this, latLng);
            }
        });

    }

    private void onMarkerClickListener(Marker marker) {

        Bar bar = mMarkerBars.get(marker);

        if (bar != null) {
            /*mBarName.setText(bar._bar_name);
            mPriceMax.setText(bar._price_max);
            mPriceMin.setText(bar._price_min);*/

            mBottomSheetLayout.showWithSheetView(mBottomSheet);
        }
    }

    private void init() {
        if (mMap != null) {
            mMap.clear();
            mMarkerBars.clear();

            mBars = BarController.getInstance().listAll();

            for (Bar bar : mBars) {
                Marker new_marker_added = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(bar._latitude, bar._longitude))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.appmark))
                        .title(bar._bar_name));
                mMarkerBars.put(new_marker_added, bar);
            }
        }
    }
}