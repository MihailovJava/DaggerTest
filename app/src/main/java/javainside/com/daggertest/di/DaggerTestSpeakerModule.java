package javainside.com.daggertest.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import javainside.com.daggertest.model.Speaker;

@Module
public class DaggerTestSpeakerModule {

    @Provides
    @Singleton
    public Speaker provideSpeaker(){
        Speaker speaker = new Speaker();
        speaker.setName("Mikhailov Nikita");
        speaker.setSpeech("Dagger 2 + Android");
        return speaker;
    }
}

