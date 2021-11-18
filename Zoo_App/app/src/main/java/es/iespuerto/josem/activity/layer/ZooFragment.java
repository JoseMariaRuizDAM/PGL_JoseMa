package es.iespuerto.josem.activity.layer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.iespuerto.josem.R;
import es.iespuerto.josem.model.contract.ZooContract;
import es.iespuerto.josem.model.helper.ComunDBHelper;

public class ZooFragment extends Fragment {
    public static final int REQUEST_UPDATE_DELETE_ZOO = 2;

    private ComunDBHelper comunDBHelper;

    private ListView mZooList;
    private ZooCursorAdapter mZooAdapter;
    private FloatingActionButton mAddButton;


    public ZooFragment() {
        // Required empty public constructor
    }

    public static ZooFragment newInstance() {
        return new ZooFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_zoo, container, false);

        // Referencias UI
        mZooList = (ListView) root.findViewById(R.id.zoo_list);
        mZooAdapter = new ZooCursorAdapter(getActivity(), null);
        mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mZooList.setAdapter(mZooAdapter);

        // Eventos
        mZooList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mZooAdapter.getItem(i);
                @SuppressLint("Range") String currentZooId = currentItem.getString(
                        currentItem.getColumnIndex(ZooContract.ZooEntry._ID));

                showDetailScreen(currentZooId);
            }
        });
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddScreen();
            }
        });


        getActivity().deleteDatabase(ComunDBHelper.DATABASE_NAME);

        // Instancia de helper
       comunDBHelper = new ComunDBHelper(getActivity());

        // Carga de datos
        loadLawyers();

        return root;
    }
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Activity.RESULT_OK == resultCode) {
            switch (requestCode) {
                case AddEditLawyerActivity.REQUEST_ADD_LAWYER:
                    showSuccessfullSavedMessage();
                    loadLawyers();
                    break;
                case REQUEST_UPDATE_DELETE_LAWYER:
                    loadLawyers();
                    break;
            }
        }
    }

    private void loadLawyers() {
        new LawyersLoadTask().execute();
    }

    private void showSuccessfullSavedMessage() {
        Toast.makeText(getActivity(),
                "Abogado guardado correctamente", Toast.LENGTH_SHORT).show();
    }

    private void showAddScreen() {
        Intent intent = new Intent(getActivity(), AddEditLawyerActivity.class);
        startActivityForResult(intent, AddEditLawyerActivity.REQUEST_ADD_LAWYER);
    }

    private void showDetailScreen(String lawyerId) {
        Intent intent = new Intent(getActivity(), LawyerDetailActivity.class);
        intent.putExtra(LawyersActivity.EXTRA_LAWYER_ID, lawyerId);
        startActivityForResult(intent, REQUEST_UPDATE_DELETE_LAWYER);
    }
*/
    private class LawyersLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mLawyersDbHelper.getAllLawyers();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mLawyersAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }
}
