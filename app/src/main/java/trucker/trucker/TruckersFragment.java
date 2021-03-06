package trucker.trucker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class TruckersFragment extends Fragment {

    MapView mMapView;
    static GoogleMap googleMap;
    static Marker marker_a;
    static Marker marker_b;
    static boolean isRunning = false;
    static Handler handler;
    LatLng sk_telecoms;
    LatLng 을지로입구역;
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isRunning = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_truckers, container, false);
        isRunning = true;
        handler = new Handler();

        mMapView = (MapView) view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;


                // For dropping a marker at a point on the Map
                sk_telecoms = new LatLng(37.265147, 127.399731);
                을지로입구역 = new LatLng(37.566056, 126.982980);

                googleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());

                marker_a = googleMap.addMarker(new MarkerOptions()
                        .position(sk_telecoms)
                        .title("신전 떡볶이")
                        .snippet("서울시 서초구 양재동 언남중학교 사거리")
                        .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("logo", 100, 100)))
                );

                marker_b = googleMap.addMarker(new MarkerOptions()
                        .position(을지로입구역)
                        .title("치킨 트럭")
                        .snippet("서울시 서초구 양재동 언남중학교 사거리")
                        .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("logo", 100, 100)))
                );

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sk_telecoms).zoom(15).build();
                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                cameraPosition = new CameraPosition.Builder().target(sk_telecoms).zoom(16).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//
//
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
////                        marker_a.setPosition(new LatLng(37.265147, 127.399731));
////                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(37.265147, 127.399731)).zoom(15).build();
////                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                        MarkerAnimation.animateMarkerToICS(marker_a, new LatLng(37.265147, 127.399731), new LatLngInterpolator.Spherical());
//                    }
//                });
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
////                        marker_a.setPosition(new LatLng(37.266732, 127.400245));
//                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(37.266732, 127.400245)).zoom(15).build();
//                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                        MarkerAnimation.animateMarkerToICS(marker_a, new LatLng(37.266732, 127.400245), new LatLngInterpolator.Spherical());
//                    }
//                });
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
////                        marker_a.setPosition(new LatLng(37.270842, 127.402310));
//                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(37.270842, 127.402310)).zoom(15).build();
//                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                        MarkerAnimation.animateMarkerToICS(marker_a, new LatLng(37.270842, 127.402310), new LatLngInterpolator.Spherical());
//                    }
//                });
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
////                        marker_a.setPosition(new LatLng(37.273547, 127.399798));
//                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(37.273547, 127.399798)).zoom(15).build();
//                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                        MarkerAnimation.animateMarkerToICS(marker_a, new LatLng(37.273547, 127.399798), new LatLngInterpolator.Spherical());
//                    }
//                });
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
////                        marker_a.setPosition(new LatLng(37.277096, 127.399249));
//                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(37.277096, 127.399249)).zoom(15).build();
//                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                        MarkerAnimation.animateMarkerToICS(marker_a, new LatLng(37.277096, 127.399249), new LatLngInterpolator.Spherical());
//                    }
//                });
//
//
//            }
//        }).start();


        return view;
    }

    public Bitmap resizeMapIcons(String iconName, int width, int height) {
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(iconName, "drawable", "trucker.trucker"));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    /**
     * Demonstrates customizing the info window and/or its contents.
     */
    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        // These are both viewgroups containing an ImageView with id "badge" and two TextViews with id
        // "title" and "snippet".
        private final View mContents;

        CustomInfoWindowAdapter() {
            mContents = getLayoutInflater(null).inflate(R.layout.custom_info_contents, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            render(marker, mContents);
            return mContents;
        }

        private void render(Marker marker, View view) {
            int badge;
            // Use the equals() method on a Marker to check for equals.  Do not use ==.

            badge = R.drawable.content_img;
            ((ImageView) view.findViewById(R.id.badge)).setImageResource(badge);

            String title = marker.getTitle();
            TextView titleUi = ((TextView) view.findViewById(R.id.title));
            if (title != null) {
                // Spannable string allows us to edit the formatting of the text.
                SpannableString titleText = new SpannableString(title);
                titleUi.setText(titleText);
            } else {
                titleUi.setText("");
            }

            String snippet = marker.getSnippet();
            TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
            if (snippet != null && snippet.length() > 12) {
                SpannableString snippetText = new SpannableString(snippet);
                snippetUi.setText(snippetText);
            } else {
                snippetUi.setText("");
            }
        }
    }

}

