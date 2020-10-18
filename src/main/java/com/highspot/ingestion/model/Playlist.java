package com.highspot.ingestion.model;

import java.util.List;
import java.util.Objects;


public class Playlist {

    private String id;
    private String user_id;
    private List<String> song_ids;

  public Playlist()
  {

  }

    public Playlist(String id)
    {
      this.id = id;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Playlist)) {
      return false;
    }
    Playlist playlist = (Playlist) o;
    return Objects.equals(getId(), playlist.getId());
  }

  @Override
  public String toString() {
    return "Playlist{" +
        "id='" + id + '\'' +
        ", user_id='" + user_id + '\'' +
        ", song_ids=" + song_ids +
        '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public List<String> getSong_ids() {
    return song_ids;
  }

  public void setSong_ids(List<String> song_ids) {
    this.song_ids = song_ids;
  }


}
