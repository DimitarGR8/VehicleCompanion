package com.vehiclecompanion.feature;

import com.vehiclecompanion.base.BaseViewModel_MembersInjector;
import com.vehiclecompanion.events.IEventBus;
import com.vehiclecompanion.usecase.GetAllFavoritesUseCase;
import com.vehiclecompanion.usecase.ToggleFavoritePoiUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class FavoritesViewModel_Factory implements Factory<FavoritesViewModel> {
  private final Provider<IEventBus> eventBusProvider;

  private final Provider<GetAllFavoritesUseCase> getAllFavoritesUseCaseProvider;

  private final Provider<ToggleFavoritePoiUseCase> toggleFavoritePoiUseCaseProvider;

  private final Provider<IEventBus> eventBusProvider2;

  public FavoritesViewModel_Factory(Provider<IEventBus> eventBusProvider,
      Provider<GetAllFavoritesUseCase> getAllFavoritesUseCaseProvider,
      Provider<ToggleFavoritePoiUseCase> toggleFavoritePoiUseCaseProvider,
      Provider<IEventBus> eventBusProvider2) {
    this.eventBusProvider = eventBusProvider;
    this.getAllFavoritesUseCaseProvider = getAllFavoritesUseCaseProvider;
    this.toggleFavoritePoiUseCaseProvider = toggleFavoritePoiUseCaseProvider;
    this.eventBusProvider2 = eventBusProvider2;
  }

  @Override
  public FavoritesViewModel get() {
    FavoritesViewModel instance = newInstance(eventBusProvider.get(), getAllFavoritesUseCaseProvider.get(), toggleFavoritePoiUseCaseProvider.get());
    BaseViewModel_MembersInjector.injectEventBus(instance, eventBusProvider2.get());
    return instance;
  }

  public static FavoritesViewModel_Factory create(Provider<IEventBus> eventBusProvider,
      Provider<GetAllFavoritesUseCase> getAllFavoritesUseCaseProvider,
      Provider<ToggleFavoritePoiUseCase> toggleFavoritePoiUseCaseProvider,
      Provider<IEventBus> eventBusProvider2) {
    return new FavoritesViewModel_Factory(eventBusProvider, getAllFavoritesUseCaseProvider, toggleFavoritePoiUseCaseProvider, eventBusProvider2);
  }

  public static FavoritesViewModel newInstance(IEventBus eventBus,
      GetAllFavoritesUseCase getAllFavoritesUseCase,
      ToggleFavoritePoiUseCase toggleFavoritePoiUseCase) {
    return new FavoritesViewModel(eventBus, getAllFavoritesUseCase, toggleFavoritePoiUseCase);
  }
}
