package com.highspot.ingestion.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;

public class ModifyPlaylist {

  private String playlistId;
  private List<String> addSong;
  private List<String> removeSong;


  @JsonGetter("playlist_id")
  public String getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(String playlistId) {
    this.playlistId = playlistId;
  }

  @Override
  public String toString() {
    return "ModifyPlaylist{" +
        "playlistId='" + playlistId + '\'' +
        ", addSong=" + addSong +
        ", removeSong=" + removeSong +
        '}';
  }

  @JsonGetter("addsong")
  public List<String> getAddSong() {
    return addSong;
  }

  public void setAddSong(List<String> addSong) {
    this.addSong = addSong;
  }

  @JsonGetter("removesong")
  public List<String> getRemoveSong() {
    return removeSong;
  }

  public void setRemoveSong(List<String> removeSong) {
    this.removeSong = removeSong;
  }
}
