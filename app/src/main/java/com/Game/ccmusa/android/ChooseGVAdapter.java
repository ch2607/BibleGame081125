package com.Game.ccmusa.android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ChooseGVAdapter  extends ArrayAdapter<ChooseModel>
{

    ImageView choose;
    ImageView number;
    ImageView lock;
    ImageView error;

    public ChooseGVAdapter(@NonNull Context context, ArrayList<ChooseModel> chooseModelArrayList) {
        super(context, 0, chooseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.ch_item, parent, false);
        }

        ChooseModel chooseModel = getItem(position);
      //  TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        choose = listitemView.findViewById(R.id.chooseid);
        number = listitemView.findViewById(R.id.numid);
        lock = listitemView.findViewById(R.id.lockid);
        error = listitemView.findViewById(R.id.errid);
     //   Log.d("Hsieh", "number  " + number);
   //     Log.d("Hsieh", "lock  " + lock);
        switch (position)
        {
            case 0:
                number.setImageResource(R.drawable.num01);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 1:
                number.setImageResource(R.drawable.num02);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 2:
                number.setImageResource(R.drawable.num03);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 3:
                number.setImageResource(R.drawable.num04);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);

                break;
            case 4:
                number.setImageResource(R.drawable.num05);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);

                break;
            case 5:
                number.setImageResource(R.drawable.num06);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);


                break;
            case 6:
                number.setImageResource(R.drawable.num07);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);

                break;
            case 7:
                number.setImageResource(R.drawable.num08);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);

                break;
            case 8:
                number.setImageResource(R.drawable.num09);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 9:
                number.setImageResource(R.drawable.num10);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 10:
                number.setImageResource(R.drawable.num11);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 11:
                number.setImageResource(R.drawable.num12);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 12:
                number.setImageResource(R.drawable.num13);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 13:
                number.setImageResource(R.drawable.num14);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;

            case 14:
                number.setImageResource(R.drawable.num15);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 15:
                number.setImageResource(R.drawable.num16);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 16:
                number.setImageResource(R.drawable.num17);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 17:
                number.setImageResource(R.drawable.num18);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 18:
                number.setImageResource(R.drawable.num19);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 19:
                number.setImageResource(R.drawable.num20);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 20:
                number.setImageResource(R.drawable.num21);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 21:
                number.setImageResource(R.drawable.num22);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 22:
                number.setImageResource(R.drawable.num23);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 23:
                number.setImageResource(R.drawable.num23);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 24:
                number.setImageResource(R.drawable.num24);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 25:
                number.setImageResource(R.drawable.num26);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 26:
                number.setImageResource(R.drawable.num27);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 27:
                number.setImageResource(R.drawable.num28);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 28:
                number.setImageResource(R.drawable.num29);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            case 29:
                number.setImageResource(R.drawable.num30);
                number.setVisibility(View.VISIBLE);
                SetTableInfo(position, choose, number, lock, error);
                break;
            default:
                break;
        }
     //   choose.setVisibility(View.GONE);
        return listitemView;
    }

    public void SetTableInfo(int position, ImageView choose, ImageView number, ImageView lock, ImageView error)
    {
        if (Main.myArrayCh.get(position) == "1")
        {
            Glide.with(getContext())
                    .load(R.drawable.choose)
                    .into(choose);
            lock.setVisibility(View.GONE);

            error.setVisibility(View.GONE);
            if ( Main.myArrayChInf.get(position) == "1")
            {
                Glide.with(getContext())
                        .load(R.mipmap.check)
                        .into(error);
                error.setVisibility(View.VISIBLE);

            }
            else
            {
                if ( Main.myArrayChInf.get(position) == "2") {
                    Glide.with(getContext())
                            .load(R.mipmap.err)
                            .into(error);
                    error.setVisibility(View.VISIBLE);
                }
                else
                {
                    if ( Main.myArrayChInf.get(position) == "3") {
                        Glide.with(getContext())
                                .load(R.mipmap.allerr)
                                .into(error);
                        error.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
        else
        {
            Glide.with(getContext())
                    .load(R.drawable.choose)
                    .into(choose);
            lock.setVisibility(View.VISIBLE);  // 放上Key Lock  here
            number.setVisibility(View.GONE);
            error.setVisibility(View.GONE);
        }
    }
}

