package trucker.trucker;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mikeafc on 15/11/26.
 */
public class HomePagerAdapter extends PagerAdapter {
    private boolean isMultiScr;

    public HomePagerAdapter(boolean isMultiScr) {
        this.isMultiScr = isMultiScr;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.layout_child, null);
        //new LinearLayout(container.getContext());
        TextView textView = (TextView) linearLayout.findViewById(R.id.pager_textview);
//        textView.setText(position + "");
//        linearLayout.setId(R.id.item_id);
        switch (position) {
            case 0:
//                linearLayout.setBackgroundColor(Color.parseColor("#2196F3"));
                linearLayout.setBackgroundResource(R.drawable.fragment_home_tarco);
                break;
            case 1:
//                linearLayout.setBackgroundColor(Color.parseColor("#673AB7"));
                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                break;
            case 2:
//                linearLayout.setBackgroundColor(Color.parseColor("#009688"));
                linearLayout.setBackgroundResource(R.drawable.fragment_home_tarco);
                break;
            case 3:
//                linearLayout.setBackgroundColor(Color.parseColor("#607D8B"));
                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                break;
            case 4:
//                linearLayout.setBackgroundColor(Color.parseColor("#F44336"));
                linearLayout.setBackgroundResource(R.drawable.fragment_home_tarco);
                break;
        }
        container.addView(linearLayout);
//        linearLayout.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, container.getContext().getResources().getDisplayMetrics());
//        linearLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, container.getContext().getResources().getDisplayMetrics());
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}