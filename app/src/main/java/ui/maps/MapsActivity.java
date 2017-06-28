package ui.maps;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import fr.cesi.basecode.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private BottomSheetLayout mBottomSheetLayout;
    private View mBottomSheet;
    private ArrayList<Marker> _my_markers;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        _my_markers = new ArrayList<>();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mBottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);


        mBottomSheet = LayoutInflater.from(this)
                .inflate(R.layout.info_commerce, mBottomSheetLayout, false);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMyLocationEnabled(true);

        //1st marker
        LatLng Bordeaux = new LatLng(44.841496, -0.570035);
        mMap.addMarker(new MarkerOptions().position(Bordeaux).title("Marker in bdx"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bordeaux));


        //2st marker
        LatLng NEW = new LatLng(64.841496, -4.570035);
        mMap.addMarker(new MarkerOptions().position(NEW).title("Marker in bdx"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(NEW));

        //click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                addMarker(latLng, "in bdx with click", mMap);
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                showInformation(marker);
                //deleteMarker(marker);

                // Return false to indicate that we have not consumed the event and that we wish
                // for the default behavior to occur (which is for the camera to move such that the
                // marker is centered and for the marker's info window to open, if it has one).
                return true;
            }
        });

    }

    private void addMarker(LatLng latLng, String title, GoogleMap map) {
        Marker marker = map.addMarker(new MarkerOptions().position(latLng).title(title));
        _my_markers.add(marker);
    }

    private void showInformation(Marker marker) {
        TextView lundi_ouverture = (TextView) mBottomSheet.findViewById(R.id.lundi_ouverture);

        lundi_ouverture.setText();
        mBottomSheetLayout.showWithSheetView(mBottomSheet);
    }

    private void deleteMarker(Marker marker) {
        marker.remove();
        _my_markers.remove(marker);
    }
}
