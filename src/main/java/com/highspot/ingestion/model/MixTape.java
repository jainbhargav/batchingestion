package com.highspot.ingestion.model;

import java.util.List;

public class MixTape {

      private List<User> users;
      private List<Playlist> playlists;
      private List<Song> songs;

  @Override
  public String toString() {
    return "MixTape{" +
        "users=" + users +
        ", playlists=" + playlists +
        ", songs=" + songs +
        '}';
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public List<Playlist> getPlaylists() {
    return playlists;
  }

  public void setPlaylists(List<Playlist> playlists) {
    this.playlists = playlists;
  }

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }
}
