package com.example.ggavi.registeration.ahn2;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import com.example.ggavi.registeration.R;

/**
 * Implementation of App Widget functionality.
 */
public class mosquitoAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        SharedPreferences pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        String grade = pref.getString("grade","");
        int color = pref.getInt("color",100);
            // Construct the RemoteViews object
            Intent intent = new Intent(context, LifeJisu_MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.open1_mosquito_app_widget);

            views.setTextViewText(R.id.appWidget_text, grade);
            views.setOnClickPendingIntent(R.id.appWidget, pendingIntent);
            views.setInt(R.id.appWidget, "setBackgroundColor",
                color);
            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);

    }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }



    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

