package org.example.gamelibrarylab.dto;

public record GameDTO (
  Long id,
  String title,
  String description,
  String publisher,
  String developer,
  String releaseDate
){}
