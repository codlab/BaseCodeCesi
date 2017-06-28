package fr.cesi.bar.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.flipboard.bottomsheet.BottomSheetLayout;

import fr.cesi.basecode.R;


public class BottomSheet extends AppCompatActivity {

    private Button _show_bottom_sheet_button;
    private BottomSheetLayout _bottom_sheet_layout;
    private View _bottom_sheet_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_sheet);

        _show_bottom_sheet_button = (Button) findViewById(R.id.show_bottom_sheet);
        _bottom_sheet_layout = (BottomSheetLayout) findViewById(R.id.bottomsheet);

        _bottom_sheet_view = LayoutInflater.from(this)
                .inflate(R.layout.view_bottom_sheet, _bottom_sheet_layout,
                        /*take the parent but do not add the view into the layout*/
                        false);

        _show_bottom_sheet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });
    }

}
