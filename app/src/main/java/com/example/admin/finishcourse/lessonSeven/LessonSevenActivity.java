package com.example.admin.finishcourse.lessonSeven;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.finishcourse.MainActivity;
import com.example.admin.finishcourse.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class LessonSevenActivity extends AppCompatActivity {
    private static final String TAG = "LessonSevenActivity";
    private List<Student> studentList;
    private LessonSevenRecyclerViewAdapter mLessonSevenRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_lesson7_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewLesson7);
        String url = Constants.LOCALHOST+Constants.PATH_STUDENT;
        Log.d(TAG,"onCreate: " +url);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        new StudentInfoProcesor().execute(Constants.LOCALHOST+Constants.PATH_STUDENT);

    }


    public void processJsonString(String students) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        studentList = Arrays.asList(gson.fromJson(students, Student[].class));
        Log.d(TAG,studentList.get(1).getName());

    }

    private class StudentInfoProcesor extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            Log.d(TAG,"doInBackground");
            InputStream inputStream;
            BufferedReader in;
            Integer result = 0;
            try {
                URL url = new URL(strings[0]);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.setRequestMethod("GET");
                int code = httpURLConnection.getResponseCode();
                if (code == 200) {
                    Log.d(TAG, "success");
                    inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    String str = convertInputStreamToString(inputStream);
                    Log.d(TAG, str);
                    processJsonString(str);
                    result = 0;
                } else {
                    result = 1;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        private String convertInputStreamToString(InputStream inputStream) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String readLine;
            StringBuffer buf = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                buf.append(readLine);
            }
            String infoString = buf.toString();
//            processJsonString(infoString);
            if (in != null) {
                in.close();
            }
            return infoString;
        }

        // this function run before excute() function
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG,"onPreExecute");
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            if (result==0){

                mLessonSevenRecyclerViewAdapter = new LessonSevenRecyclerViewAdapter(LessonSevenActivity.this,studentList);
                mRecyclerView.setAdapter(mLessonSevenRecyclerViewAdapter);
                mLessonSevenRecyclerViewAdapter.setOnItemListener(new LessonSevenRecyclerViewAdapter.OnItemListener() {
                    @Override
                    public void onItemClick(String idStudent) {
                        Log.d(TAG,"onItemClick");
                        Intent intent = new Intent(LessonSevenActivity.this,LessonSevenSubActivity.class);
                        intent.putExtra("student",studentList.get(Integer.parseInt(idStudent)-1));
                        startActivityForResult(intent,1);
                    }
                });
                Log.d(TAG,"onPostExecute done");
            }
            else {
                Toast.makeText(LessonSevenActivity.this,"Something went wrong!!!",Toast.LENGTH_LONG);
            }
        }
    }
}
