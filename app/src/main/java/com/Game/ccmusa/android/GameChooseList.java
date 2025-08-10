package com.Game.ccmusa.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameChooseList extends Activity {

    GridView chooseGV;
    protected String resourceType;
    ChooseGVAdapter adapter;
    Context ctx;
    int BUFFER_SIZE = 50;
    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(layoutResID, null);
        resourceType = (String) view.getTag();
        Log.d("cfh", "GameChooselist = " + resourceType);
        super.setContentView(view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamechooselist);
        ctx = getApplication();
        View rootView = findViewById(android.R.id.content).getRootView();
        Object tag = rootView.getTag();

        if (tag != null) {
            Log.d("LayoutTag", "目前使用的 layout 是: " + tag.toString());
        } else {
            Log.d("LayoutTag", "這個 layout 沒有設定 tag");
        }


        chooseGV = findViewById(R.id.idchoose);

        // ✅ 建立 Adapter
        final ArrayList<ChooseModel> chooseModelArrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            chooseModelArrayList.add(new ChooseModel(
                    String.valueOf(i),
                    R.drawable.choose,
                    getNumDrawable(i),
                    R.mipmap.err
            ));
        }
        adapter = new ChooseGVAdapter(this, chooseModelArrayList);
        chooseGV.setAdapter(adapter);

        // ✅ 載入初始狀態
        loadGameStatus();

        chooseGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Main.cnum = position;
                // ✅ 只能開啟已解鎖的遊戲
                if ("1".equals(Main.myArrayCh.get(position))) {
                    Intent intent = new Intent(GameChooseList.this, ChooseGridList.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cfh", "✅ onResume: 重新載入遊戲狀態");
        loadGameStatus();
        adapter.notifyDataSetChanged();
    }

    private void loadGameStatus() {
        Main.myArrayCh = new ArrayList<>();
        Main.myArrayChInf = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            String name = (Main.setcn) ? "cse" + i + ".txt" : "ce" + i + ".txt";
            try {
                InputStream inputStream = ctx.openFileInput(name);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), BUFFER_SIZE);
                String line;
                int ret = 0;
                while ((line = br.readLine()) != null) {
                    ret = Integer.parseInt(line);
                }
                br.close();

                // ✅ 更新狀態
                if (ret == 1) { // 全對
                    Main.myArrayCh.add("1");
                    Main.myArrayChInf.add("1");
                    Main.saveindx = i;
                } else if (ret == 2) { // 有錯
                    Main.myArrayCh.add("1");
                    Main.myArrayChInf.add("2");
                    Main.saveindx = i;
                    Main.saveerr = ret;
                } else {
                    Main.myArrayCh.add("1");
                    Main.myArrayChInf.add("3");
                    Main.saveerr = ret;
                    Main.saveindx = i;
                }

            } catch (IOException e) {
                if (i == 0) {
                    // ✅ 第一個遊戲預設解鎖
                    Main.myArrayCh.add("1");
                    Main.myArrayChInf.add("0");
                } else {
                    // ✅ 其他遊戲預設鎖住
                    if (i == Main.saveindx + 1) {
                        Main.myArrayCh.add("1");
                        Main.myArrayChInf.add("0");
                    } else {
                        Main.myArrayCh.add("0");
                        Main.myArrayChInf.add("0");
                    }
                }
            }
            Log.d("cfh", "遊戲 " + i + " 狀態: " + Main.myArrayChInf.get(i));
        }
    }

    private int getNumDrawable(int index) {
        switch (index) {
            case 0: return R.drawable.num01;
            case 1: return R.drawable.num02;
            case 2: return R.drawable.num03;
            case 3: return R.drawable.num04;
            case 4: return R.drawable.num05;
            case 5: return R.drawable.num06;
            case 6: return R.drawable.num07;
            case 7: return R.drawable.num08;
            case 8: return R.drawable.num09;
            case 9: return R.drawable.num10;
            case 10: return R.drawable.num11;
            case 11: return R.drawable.num12;
            case 12: return R.drawable.num13;
            case 13: return R.drawable.num14;
            case 14: return R.drawable.num15;
            case 15: return R.drawable.num16;
            case 16: return R.drawable.num17;
            case 17: return R.drawable.num18;
            case 18: return R.drawable.num19;
            case 19: return R.drawable.num20;
            case 20: return R.drawable.num21;
            case 21: return R.drawable.num22;
            case 22: return R.drawable.num23;
            case 23: return R.drawable.num24;
            case 24: return R.drawable.num25;
            case 25: return R.drawable.num26;
            case 26: return R.drawable.num27;
            case 27: return R.drawable.num28;
            case 28: return R.drawable.num29;
            case 29: return R.drawable.num30;
            default: return R.drawable.num01;
        }
    }
}
