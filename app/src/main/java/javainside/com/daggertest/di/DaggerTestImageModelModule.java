package javainside.com.daggertest.di;

import dagger.Module;
import dagger.Provides;
import javainside.com.daggertest.model.ImageModel;

@Module
public class DaggerTestImageModelModule {

    @Provides
    public ImageModel provideImageModel(String url){
        ImageModel model = new ImageModel();
        model.setImageURL(url);
        return model;
    }

    @Provides
    public String provideUrl(){
        return "http://goo.gl/stSwX0";
    }
}
