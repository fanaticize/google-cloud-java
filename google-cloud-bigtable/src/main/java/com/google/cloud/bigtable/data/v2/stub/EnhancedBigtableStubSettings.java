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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.data.v2.wrappers.Query;
import com.google.cloud.bigtable.data.v2.wrappers.Row;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import org.threeten.bp.Duration;

/**
 * Settings class to configure an instance of {@link EnhancedBigtableStub}.
 *
 * <p>Sane defaults are provided for most settings:
 *
 * <ul>
 *   <li>The default service address (bigtable.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The only required setting is the instance name.
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <pre>{@code
 * BigtableDataSettings.Builder settingsBuilder = BigtableDataSettings.newBuilder()
 *   .setInstanceName(InstanceName.of("my-project", "my-instance-id"))
 *   .setAppProfileId("default");
 *
 * settingsBuilder.readRowsSettings()
 *  .setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE);
 *
 * BigtableDataSettings settings = builder.build();
 * }</pre>
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class EnhancedBigtableStubSettings extends StubSettings<EnhancedBigtableStubSettings> {
  // The largest message that can be received is a 256 MB ReadRowsResponse.
  private static final int MAX_MESSAGE_SIZE = 256 * 1024 * 1024;
  private static final String SERVER_DEFAULT_APP_PROFILE_ID = "";

  private final InstanceName instanceName;
  private final String appProfileId;

  private final ServerStreamingCallSettings<Query, Row> readRowsSettings;

  private EnhancedBigtableStubSettings(Builder builder) {
    super(builder);
    instanceName = builder.instanceName;
    appProfileId = builder.appProfileId;

    // Per method settings.
    readRowsSettings = builder.readRowsSettings.build();
  }

  /** Create a new builder. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns the target instance */
  public InstanceName getInstanceName() {
    return instanceName;
  }

  /** Returns the configured AppProfile to use */
  public String getAppProfileId() {
    return appProfileId;
  }

  /** Returns the object with the settings used for calls to ReadRows. */
  public ServerStreamingCallSettings<Query, Row> readRowsSettings() {
    return readRowsSettings;
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Builder for BigtableDataSettings. */
  public static class Builder extends StubSettings.Builder<EnhancedBigtableStubSettings, Builder> {
    private InstanceName instanceName;
    private String appProfileId;

    private final ServerStreamingCallSettings.Builder<Query, Row> readRowsSettings;

    /**
     * Initializes a new Builder with sane defaults for all settings.
     *
     * <p>Most defaults are extracted from BaseBigtableDataSettings, however some of the more
     * complex defaults are configured explicitly here. Once the overlayed defaults are configured,
     * the base settings are augmented to work with overlayed functionality (like disabling retries
     * in the underlying GAPIC client for batching).
     */
    private Builder() {
      this.appProfileId = SERVER_DEFAULT_APP_PROFILE_ID;

      // Defaults provider
      BigtableStubSettings.Builder baseDefaults = BigtableStubSettings.newBuilder();

      setEndpoint(baseDefaults.getEndpoint());
      setCredentialsProvider(baseDefaults.getCredentialsProvider());
      setTransportChannelProvider(
          InstantiatingGrpcChannelProvider.newBuilder()
              // TODO: tune channels
              .setChannelsPerCpu(2)
              .setMaxInboundMessageSize(MAX_MESSAGE_SIZE)
              .build());

      // Per-method settings using baseSettings for defaults.
      readRowsSettings = ServerStreamingCallSettings.newBuilder();
      /* TODO: copy timeouts, retryCodes & retrySettings from baseSettings.readRows once it exists in GAPIC */
      readRowsSettings
          .setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE, Code.ABORTED)
          .setTimeoutCheckInterval(Duration.ofSeconds(10))
          .setIdleTimeout(Duration.ofMinutes(5))
          .setRetrySettings(
              RetrySettings.newBuilder()
                  .setMaxAttempts(10)
                  .setTotalTimeout(Duration.ofHours(1))
                  .setInitialRetryDelay(Duration.ofMillis(100))
                  .setRetryDelayMultiplier(1.3)
                  .setMaxRetryDelay(Duration.ofMinutes(1))
                  .setInitialRpcTimeout(Duration.ofSeconds(20))
                  .setRpcTimeoutMultiplier(1)
                  .setMaxRpcTimeout(Duration.ofSeconds(20))
                  .build());
    }

    private Builder(EnhancedBigtableStubSettings settings) {
      super(settings);
      instanceName = settings.instanceName;
      appProfileId = settings.appProfileId;

      // Per method settings.
      readRowsSettings = settings.readRowsSettings.toBuilder();
    }

    // <editor-fold desc="Private Helpers">
    /**
     * Copies settings from unary RPC to another. This is necessary when modifying request and
     * response types while trying to retain retry settings.
     */
    private static void copyRetrySettings(
        UnaryCallSettings.Builder<?, ?> source, UnaryCallSettings.Builder<?, ?> dest) {
      dest.setRetryableCodes(source.getRetryableCodes());
      dest.setRetrySettings(source.getRetrySettings());
    }
    // </editor-fold>

    // <editor-fold desc="Public API">
    /**
     * Sets the target instance. This setting is required. All RPCs will be made in the context of
     * this setting.
     */
    public Builder setInstanceName(@Nonnull InstanceName instanceName) {
      Preconditions.checkNotNull(instanceName);
      this.instanceName = instanceName;
      return this;
    }

    /** Gets the {@link InstanceName} that was previously set on this Builder. */
    public InstanceName getInstanceName() {
      return instanceName;
    }

    /**
     * Sets the AppProfile to use. An application profile (sometimes also shortened to "app
     * profile") is a group of configuration parameters for an individual use case. A client will
     * identify itself with an application profile ID at connection time, and the requests will be
     * handled according to that application profile.
     */
    public Builder setAppProfileId(@Nonnull String appProfileId) {
      Preconditions.checkNotNull(appProfileId, "AppProfileId can't be null");
      this.appProfileId = appProfileId;
      return this;
    }

    /** Gets the app profile id that was previously set on this Builder. */
    public String getAppProfileId() {
      return appProfileId;
    }

    /** Returns the builder for the settings used for calls to readRows. */
    public ServerStreamingCallSettings.Builder<Query, Row> readRowsSettings() {
      return readRowsSettings;
    }

    @SuppressWarnings("unchecked")
    public EnhancedBigtableStubSettings build() {
      Preconditions.checkState(instanceName != null, "InstanceName must be set");

      return new EnhancedBigtableStubSettings(this);
    }
    // </editor-fold>
  }
}
