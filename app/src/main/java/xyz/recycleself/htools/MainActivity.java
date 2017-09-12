package xyz.recycleself.htools;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "hao";
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fm = getSupportFragmentManager();
        CursorLoaderListFragment list = new CursorLoaderListFragment();
        fm.beginTransaction().replace(R.id.root, list).commit();
    }

    public static class CursorLoaderListFragment extends ListFragment
            implements LoaderManager.LoaderCallbacks<Cursor> {

        // This is the Adapter being used to display the list's data.
        SimpleCursorAdapter mAdapter;

        // If non-null, this is the current filter the user has provided.
        String mCurFilter;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {


            mAdapter = new SimpleCursorAdapter(getActivity(),
                    android.R.layout.simple_list_item_2, null,
                    new String[]{Contacts.DISPLAY_NAME, Contacts.CONTACT_STATUS},
                    new int[]{android.R.id.text1, android.R.id.text2}, 0);
            setListAdapter(mAdapter);

            //这个地方初始化了我们的loader
            getLoaderManager().initLoader(0, null, this);

            super.onActivityCreated(savedInstanceState);
        }


        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            // Insert desired behavior here.
            Log.i("FragmentComplexList", "Item clicked: " + id);
        }

        // These are the Contacts rows that we will retrieve.
        static final String[] CONTACTS_SUMMARY_PROJECTION = new String[]{
                Contacts._ID,
                Contacts.DISPLAY_NAME,
                Contacts.CONTACT_STATUS,
                Contacts.CONTACT_PRESENCE,
                Contacts.PHOTO_ID,
                Contacts.LOOKUP_KEY,
        };

        //只会调用一次
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            // This is called when a new Loader needs to be created.  This
            // sample only has one Loader, so we don't care about the ID.
            // First, pick the base URI to use depending on whether we are
            // currently filtering.
            Uri baseUri;
            if (mCurFilter != null) {
                baseUri = Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI,
                        Uri.encode(mCurFilter));
            } else {
                baseUri = Contacts.CONTENT_URI;
            }

            // Now create and return a CursorLoader that will take care of
            // creating a Cursor for the data being displayed.
            String select = "((" + Contacts.DISPLAY_NAME + " NOTNULL) AND ("
                    + Contacts.HAS_PHONE_NUMBER + "=1) AND ("
                    + Contacts.DISPLAY_NAME + " != '' ))";
            //返回的是对这个数据源的监控
            return new CursorLoader(getActivity(), baseUri,
                    CONTACTS_SUMMARY_PROJECTION, select, null,
                    Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
        }

        //每次数据源都有更新的时候，就会回调这个方法，然后update 我们的ui了。
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

            // Swap the new cursor in.  (The framework will take care of closing the
            // old cursor once we return.)
            mAdapter.swapCursor(data);

            // The list should now be shown.
            if (isResumed()) {
                setListShown(true);
            } else {
                setListShownNoAnimation(true);
            }
        }

        public void onLoaderReset(Loader<Cursor> loader) {
            // This is called when the last Cursor provided to onLoadFinished()
            // above is about to be closed.  We need to make sure we are no
            // longer using it.
            mAdapter.swapCursor(null);
        }
    }

}
