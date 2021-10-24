// Generated by Dagger (https://dagger.dev).
package vulong.todoapp.ui.viewmodels;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;
import vulong.todoapp.data.repositories.ToDoRepository;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SharedViewModel_Factory implements Factory<SharedViewModel> {
  private final Provider<ToDoRepository> repositoryProvider;

  public SharedViewModel_Factory(Provider<ToDoRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SharedViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static SharedViewModel_Factory create(Provider<ToDoRepository> repositoryProvider) {
    return new SharedViewModel_Factory(repositoryProvider);
  }

  public static SharedViewModel newInstance(ToDoRepository repository) {
    return new SharedViewModel(repository);
  }
}
