package com.sagarnileshshah.carouselmvp.di;


import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.sagarnileshshah.carouselmvp.data.DataRepository;
import com.sagarnileshshah.carouselmvp.data.local.LocalDataSource;
import com.sagarnileshshah.carouselmvp.data.remote.RemoteDataSource;
import com.sagarnileshshah.carouselmvp.util.NetworkHelper;
import com.sagarnileshshah.carouselmvp.util.threading.MainUiThread;
import com.sagarnileshshah.carouselmvp.util.threading.ThreadExecutor;

public class Injection {

    public static DataRepository provideDataRepository(MainUiThread mainUiThread, ThreadExecutor threadExecutor, DatabaseDefinition databaseDefinition) {
        return DataRepository.getInstance(RemoteDataSource.getInstance(mainUiThread, threadExecutor),
                LocalDataSource.getInstance(mainUiThread, threadExecutor, databaseDefinition), NetworkHelper.getInstance());
    }
}
