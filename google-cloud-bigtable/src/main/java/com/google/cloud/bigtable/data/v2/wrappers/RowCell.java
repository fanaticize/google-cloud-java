/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.wrappers;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.protobuf.ByteString;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Default representation of a cell in a {@link Row}. */
@AutoValue
public abstract class RowCell {
  /** Creates a new instance of the {@link RowCell}. */
  @InternalApi
  public static RowCell create(
      String family, ByteString qualifier, long timestamp, List<String> labels, ByteString value) {
    return new AutoValue_RowCell(family, qualifier, timestamp, value, labels);
  }

  /** The cell's family */
  @Nonnull
  public abstract String family();

  /** The cell's qualifier (column name) */
  @Nullable
  public abstract ByteString qualifier();

  /** The timestamp of the cell */
  public abstract long timestamp();

  /** The value of the cell */
  @Nonnull
  public abstract ByteString value();

  /**
   * The labels assigned to the cell
   *
   * @see Filters#label(String)
   */
  @Nonnull
  public abstract List<String> labels();
}
