package lk.ceylonedge.nameshort.test;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;

public class MainActivity extends Activity {
	
	private String comment = "";
	private double edittext_length = 0;
	private String Last = "";
	private String First = "";
	private String First_of_last = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private Button button1;
	private TextView textview1;
	private EditText edittext1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		button1 = findViewById(R.id.button1);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext1.getText().toString().equals("")) {
					if (edittext1.getText().toString().contains(" ")) {
						First = edittext1.getText().toString().substring((int)(0), (int)(1));
						First_of_last = edittext1.getText().toString().substring((int)(edittext_length + 1), (int)(edittext1.getText().toString().length()));
						Last = First_of_last.substring((int)(0), (int)(1));
						textview1.setText(First.concat(Last));
					}
					else {
						textview1.setText(edittext1.getText().toString().substring((int)(0), (int)(1)));
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Empty input");
				}
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!edittext1.getText().toString().contains(" ")) {
					edittext_length = _charSeq.length();
				}
				if (_charSeq.length() == 0) {
					textview1.setText("##");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		_Corner_Reduce(50, 3, 5, "#ECEFF1", "#ffffff", linear2);
		_Corner_Reduce(50, 3, 5, "#ECEFF1", "#ffffff", linear3);
		_Corner_Reduce(50, 3, 5, "#ECEFF1", "#ffffff", button1);
	}
	
	public void _Corner_Reduce(final double _reduce, final double _stroke, final double _elevation, final String _edge, final String _inside, final View _view) {
		float r = (float)_reduce;
		float e =(float)_elevation;
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
		gd.setColor(Color.parseColor(_inside));
		gd.setCornerRadius(r);
		gd.setStroke((int)_stroke, Color.parseColor(_edge));
		_view.setBackground(gd);
		_view.setElevation(e);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}