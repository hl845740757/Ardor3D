/**
 * Copyright (c) 2008-2021 Bird Dog Games, Inc.
 *
 * This file is part of Ardor3D.
 *
 * Ardor3D is free software: you can redistribute it and/or modify it
 * under the terms of its license which may be found in the accompanying
 * LICENSE file or at <https://git.io/fjRmv>.
 */

package com.ardor3d.image;

import com.ardor3d.util.Ardor3dException;

public enum TextureStoreFormat {
  /**
   * When used in texture loading, this indicates to convert the image's data properties to its
   * closest TextureStoreFormat <strong>compressed</strong> format.
   */
  GuessCompressedFormat,
  /**
   * When used in texture loading, this indicates to convert the image's data properties to its
   * closest TextureStoreFormat format.
   */
  GuessNoCompressedFormat,
  /**
   * 3 bit red, 3 bit green, 3 bit blue - often forced to 16 bit by the card
   */
  R3G3B2,
  /**
   * 4 bits per red, green and blue
   */
  RGB4,
  /**
   * 5 bits per red, green and blue
   */
  RGB5,
  /**
   * 8 bits per red, green and blue
   */
  RGB8,
  /**
   * 10 bits per red, green and blue - usually falls back to 8 bits on the card
   */
  RGB10,
  /**
   * 12 bits per red, green and blue - usually falls back to 8 bits on the card
   */
  RGB12,
  /**
   * 16 bits per red, green and blue - usually falls back to 8 bits on the card
   */
  RGB16,
  /**
   * 2 bits per red, green, blue and alpha - often forced to RGBA4 by the card
   */
  RGBA2,
  /**
   * 4 bits per red, green, blue and alpha
   */
  RGBA4,
  /**
   * 5 bits per red, green and blue. 1 bit of alpha
   */
  RGB5A1,
  /**
   * 8 bits per red, green, blue and alpha
   */
  RGBA8,
  /**
   * 10 bits per red, green and blue. 2 bits of alpha - often forced to RGBA8 by the card
   */
  RGB10A2,
  /**
   * 12 bits per red, green, blue and alpha - often forced to RGBA8 by the card
   */
  RGBA12,
  /**
   * 16 bits per red, green, blue and alpha - often forced to RGBA8 by the card
   */
  RGBA16,
  /**
   * RGB, potentially compressed and stored by the card.
   */
  CompressedRed,
  /**
   * RGB, potentially compressed and stored by the card.
   */
  CompressedRG,
  /**
   * RGB, potentially compressed and stored by the card.
   */
  CompressedRGB,
  /**
   * RGBA, potentially compressed and stored by the card.
   */
  CompressedRGBA,
  /**
   * Image data already in DXT1 format.
   */
  NativeDXT1,
  /**
   * Image data already in DXT1 (with Alpha) format.
   */
  NativeDXT1A,
  /**
   * Image data already in DXT3 format.
   */
  NativeDXT3,
  /**
   * Image data already in DXT5 format.
   */
  NativeDXT5,
  /**
   * Image data already in LATC format - Luminance only
   */
  NativeLATC_L,
  /**
   * Image data already in LATC format - Luminance+Alpha
   */
  NativeLATC_LA,
  /**
   * depth component format - let card choose bit size
   */
  Depth,
  /**
   * 16 bit depth component format
   */
  Depth16,
  /**
   * 24 bit depth component format
   */
  Depth24,
  /**
   * 32 bit depth component format - often stored in Depth24 format by the card.
   */
  Depth32,
  /**
   * Floating point depth format.
   */
  Depth32F,
  /**
   * 16 bit float per red, green and blue
   */
  RGB16F,
  /**
   * 32 bit float per red, green and blue
   */
  RGB32F,
  /**
   * 16 bit float per red, green, blue and alpha
   */
  RGBA16F,
  /**
   * 32 bit float per red, green, blue and alpha
   */
  RGBA32F,
  /**
   * 8 bit, one-component format
   */
  R8,
  /**
   * 8 bit integer, one-component format
   */
  R8I,
  /**
   * 8 bit unsigned integer, one-component format
   */
  R8UI,
  /**
   * 16 bit, one-component format
   */
  R16,
  /**
   * 16 bit integer, one-component format
   */
  R16I,
  /**
   * 16 bit unsigned integer, one-component format
   */
  R16UI,
  /**
   * 16 bit float, one-component format
   */
  R16F,
  /**
   * 32 bit integer, one-component format
   */
  R32I,
  /**
   * 32 bit unsigned integer, one-component format
   */
  R32UI,
  /**
   * 32 bit float, one-component format
   */
  R32F,
  /**
   * 8 bit, two-component format
   */
  RG8,
  /**
   * 8 bit integer, two-component format
   */
  RG8I,
  /**
   * 8 bit unsigned integer, two-component format
   */
  RG8UI,
  /**
   * 16 bit, two-component format
   */
  RG16,
  /**
   * 16 bit integer, two-component format
   */
  RG16I,
  /**
   * 16 bit unsigned integer, two-component format
   */
  RG16UI,
  /**
   * 16 bit float, two-component format
   */
  RG16F,
  /**
   * 32 bit integer, two-component format
   */
  RG32I,
  /**
   * 32 bit unsigned integer, two-component format
   */
  RG32UI,
  /**
   * 32 bit float, two-component format.
   */
  RG32F;

  public boolean isDepthFormat() {
    return this == Depth16 || this == Depth24 || this == Depth32 || this == Depth || this == Depth32F;
  }

  public boolean isCompressed() {
    switch (this) {
      case NativeDXT1:
      case NativeDXT1A:
      case NativeDXT3:
      case NativeDXT5:
      case NativeLATC_L:
      case NativeLATC_LA:
        return true;
      default:
        return false;
    }
  }

  public int getComponents() {
    switch (this) {
      case RGBA2:
      case RGBA4:
      case RGB5A1:
      case RGBA8:
      case RGB10A2:
      case RGBA12:
      case RGBA16:
      case RGBA16F:
      case RGBA32F:
      case CompressedRGBA:
        return 4;
      case RGB4:
      case RGB5:
      case RGB8:
      case RGB10:
      case RGB12:
      case RGB16F:
      case RGB16:
      case RGB32F:
      case CompressedRGB:
        return 3;
      case RG8:
      case RG8I:
      case RG8UI:
      case RG16:
      case RG16F:
      case RG16I:
      case RG16UI:
      case RG32F:
      case RG32I:
      case RG32UI:
      case R3G3B2:
      case CompressedRG:
        return 2;
      case Depth:
      case Depth16:
      case Depth24:
      case Depth32:
      case Depth32F:
      case R8:
      case R8I:
      case R8UI:
      case R16:
      case R16F:
      case R16I:
      case R16UI:
      case R32F:
      case R32I:
      case R32UI:
      case CompressedRed:
        return 1;
      case GuessCompressedFormat:
      case GuessNoCompressedFormat:
      case NativeDXT1:
      case NativeDXT1A:
      case NativeDXT3:
      case NativeDXT5:
      case NativeLATC_L:
      case NativeLATC_LA:
      default:
        throw new Ardor3dException("Unhandled format: " + this);
    }
  }
}
