package com.highspot.ingestion.model;


import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;

public class Changes {

  private List<Playlist> addPlaylists;
  private List<String> removePlaylists;
  private List<ModifyPlaylist> modifyPlaylists;

  @Override
  public String toString() {
    return "Changes{" +
        "addPlaylists=" + addPlaylists +
        ", removePlaylists=" + removePlaylists +
        ", modifyPlaylists=" + modifyPlaylists +
        '}';
  }

  @JsonGetter("addplaylists")
  public List<Playlist> getAddPlaylists() {
    return addPlaylists;
  }

  public void setAddPlaylists(List<Playlist> addPlaylists) {
    this.addPlaylists = addPlaylists;
  }

  @JsonGetter("removeplaylists")
  public List<String> getRemovePlaylists() {
    return removePlaylists;
  }

  public void setRemovePlaylists(List<String> removePlaylists) {
    this.removePlaylists = removePlaylists;
  }

  @JsonGetter("modifyplaylists")
  public List<ModifyPlaylist> getModifyPlaylists() {
    return modifyPlaylists;
  }

  public void setModifyPlaylists(
      List<ModifyPlaylist> modifyPlaylists) {
    this.modifyPlaylists = modifyPlaylists;
  }
}
