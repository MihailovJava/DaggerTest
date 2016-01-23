package javainside.com.daggertest.di;

import javax.inject.Singleton;

import dagger.Component;
import javainside.com.daggertest.activity.MainActivity;
import javainside.com.daggertest.model.Speaker;

@Singleton
@Component(
        modules = {
                DaggerTestImageModelModule.class,
                DaggerTestSpeakerModule.class
        }
)
public interface IDaggerTestComponent {
    void inject(MainActivity mainActivity);
    Speaker speaker();
}
