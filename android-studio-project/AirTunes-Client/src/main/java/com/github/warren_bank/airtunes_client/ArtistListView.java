package com.github.warren_bank.airtunes_client;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArtistListView extends ListActivity {
  private List<Artist> list;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    list = Artist.allArtists(this);
    setListAdapter(new ArrayAdapter<Artist>(this, R.layout.list_item, list));

    getListView().setTextFilterEnabled(true);
  }

  protected void onListItemClick(ListView l, View v, int position, long id) {
    ((Peeler)getParent()).setSongList(list.get(position).songs(getParent()));
    ((Peeler)getParent()).switchToCurrentTab();
  }
}