package com.example.admin.finishcourse.lessonEight;
/**
 * @author Thuan Envity
 * @date 2018/12/27
 */

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */
import com.example.admin.finishcourse.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LessonEightActivity extends AppCompatActivity {
    private static final String TAG = "LessonEightActivity";
    private EditText edtName;
    private EditText edtClassName;
    private Button btnAdd;
    private RecyclerView mRecyclerView;
    private LessonEightRecyclerViewAdapter mLessonEightRecyclerViewAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_main);
        setTitle("Lesson 8");
        studentList = new ArrayList<>();
        edtName = (EditText) findViewById(R.id.edtNameLesson8);
        edtClassName = (EditText) findViewById(R.id.edtClassLesson8);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = createStudent();
                mLessonEightRecyclerViewAdapter.update(studentList);
                //    new StudentInfoProcesor().execute(Constants.LOCALHOST + Constants.PATH_STUDENT, "post", json);
                Toast.makeText(LessonEightActivity.this, "clickkk", Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewLesson8);
        String url = Constants.LOCALHOST + Constants.PATH_STUDENT;
        Log.d(TAG, "onCreate: " + url);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        new StudentInfoProcesor().execute(Constants.LOCALHOST + Constants.PATH_STUDENT, "get");
    }

    public void processJsonString(String students) {

        Gson gson = new Gson();
        studentList = new LinkedList<>(Arrays.asList(gson.fromJson(students, Student[].class)));
        Log.d(TAG, studentList.get(1).getName());

    }

    private String createStudent() {
        Student student = new Student();

        student.setId(studentList.size() + 1);
        student.setName(edtName.getText().toString());
        student.setClassName(edtClassName.getText().toString());
        edtName.setText(" ");
        edtClassName.setText(" ");

        studentList.add(student);

        Gson gson = new Gson();
        final String json = gson.toJson(student);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL(Constants.LOCALHOST + Constants.PATH_STUDENT);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                try {
                    httpURLConnection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
                httpURLConnection.setDoOutput(true);
                BufferedWriter bv = null;
                try {
                    bv = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                    bv.write(json);
                    bv.flush();
                    bv.close();
                    httpURLConnection.getResponseCode();
                    httpURLConnection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();
        Log.d(TAG, json);
        return json;
    }


    private class StudentInfoProcesor extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            Log.d(TAG, "doInBackground");
            InputStream inputStream;
            BufferedReader in;
            Integer result = 0;
            try {


                Log.d(TAG, strings[0]);
                Log.d(TAG, strings[1]);
                Integer a = strings[1].toString().compareTo("get");
                Log.d(TAG, a.toString());
                if (strings[1].toString().compareTo("get") == a) {
                    URL url = new URL(strings[0]);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setRequestProperty("Accept", "application/json");
                    httpURLConnection.setRequestMethod("GET");
                    int code = httpURLConnection.getResponseCode();
                    Log.d("codeee", String.valueOf(code));
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
                } else {
                    Log.d("Lesson8Activity", "POSTTTTTT");
                    URL url = new URL(strings[0]);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setRequestProperty("Accept", "application/json");
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    BufferedWriter bv = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                    bv.write(strings[2]);
                    bv.flush();
                    bv.close();
                    httpURLConnection.getResponseCode();
                    httpURLConnection.disconnect();
                    result = 2;
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
            Log.d(TAG, "onPreExecute");
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            if (result == 0) {

                mLessonEightRecyclerViewAdapter = new LessonEightRecyclerViewAdapter(LessonEightActivity.this, studentList);
                mRecyclerView.setAdapter(mLessonEightRecyclerViewAdapter);
                mLessonEightRecyclerViewAdapter.setOnItemListener(new LessonEightRecyclerViewAdapter.OnItemListener() {
                    @Override
                    public void onItemClick(Integer idStudent) {
                        Log.d(TAG, "onItemClick");
                        Toast.makeText(LessonEightActivity.this, "Hello " + studentList.get(idStudent - 1).getName(), Toast.LENGTH_SHORT).show();
                    }

                });
                Log.d(TAG, "onPostExecute done");
            } else if (result == 2) {
                Log.d(TAG, "onPostExecute result =2");
                mLessonEightRecyclerViewAdapter.update(studentList);
            } else {
                Toast.makeText(LessonEightActivity.this, "Something went wrong!!!", Toast.LENGTH_LONG);
            }
        }
    }
}