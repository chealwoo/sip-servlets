/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

/*
  +---------------------------------------------------------------------------+
  | Facebook Development Platform Java Client                                 |
  +---------------------------------------------------------------------------+
  | Copyright (c) 2007-2008 Facebook, Inc.                                    |
  | All rights reserved.                                                      |
  |                                                                           |
  | Redistribution and use in source and binary forms, with or without        |
  | modification, are permitted provided that the following conditions        |
  | are met:                                                                  |
  |                                                                           |
  | 1. Redistributions of source code must retain the above copyright         |
  |    notice, this list of conditions and the following disclaimer.          |
  | 2. Redistributions in binary form must reproduce the above copyright      |
  |    notice, this list of conditions and the following disclaimer in the    |
  |    documentation and/or other materials provided with the distribution.   |
  |                                                                           |
  | THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR      |
  | IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES |
  | OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.   |
  | IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,          |
  | INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT  |
  | NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, |
  | DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY     |
  | THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT       |
  | (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF  |
  | THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.         |
  +---------------------------------------------------------------------------+
  | For help with this library, contact developers-help@facebook.com          |
  +---------------------------------------------------------------------------+
*/
package com.facebook.api;

import org.json.simple.JSONObject;


public class PhotoTag {
  private double _x;
  private double _y;
  private Integer _taggedUserId;
  private String _text;

  public PhotoTag(String text, double x, double y) {
    assert (null != text && !"".equals(text));
    this._text = text;
    this._taggedUserId = null;
    this.setCoordinates(x, y);
  }

  public PhotoTag(int taggedUserId, double x, double y) {
    assert (0 < taggedUserId);
    this._text = null;
    this._taggedUserId = taggedUserId;
    this.setCoordinates(x, y);
  }

  private void setCoordinates(double x, double y) {
    assert (0.0 <= x && x <= 00.0);
    assert (0.0 <= y && y <= 100.0);
    this._x = x;
    this._y = y;
  }

  public boolean hasTaggedUser() {
    return null != this._taggedUserId;
  }

  public double getX() {
    return this._x;
  }

  public double getY() {
    return this._y;
  }

  public String getText() {
    return this._text;
  }

  public Integer getTaggedUserId() {
    return this._taggedUserId;
  }

  public JSONObject jsonify() {
    JSONObject ret = new JSONObject();
    ret.put("x", this.getX());
    ret.put("y", this.getY());
    if (hasTaggedUser()) {
      ret.put("tag_uid", getTaggedUserId());
    } else {
      ret.put("tag_text", getText());
    }
    return ret;
  }
}
