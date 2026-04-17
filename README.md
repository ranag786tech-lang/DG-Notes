# DG Notes

Production-style mini Android Notes app using **Clean Architecture + MVVM + Supabase**.

## Features
- Add, list, update, and delete notes.
- Layered architecture (`domain`, `data`, `app`).
- Jetpack Compose UI.
- Supabase integration (PostgREST/Auth/Realtime plugin-ready).

## Setup
1. Create a Supabase table:
   ```sql
   create extension if not exists "uuid-ossp";

   create table if not exists notes (
     id uuid default uuid_generate_v4() primary key,
     content text not null,
     created_at timestamp with time zone default now(),
     user_id uuid
   );
   ```
2. Put keys in `gradle.properties`:
   ```properties
   SUPABASE_URL=https://YOUR_PROJECT.supabase.co
   SUPABASE_ANON_KEY=YOUR_ANON_KEY
   ```
3. Build:
   ```bash
   gradle :app:assembleDebug
   ```

## Structure
- `app/src/main/java/com/dgnotes/app/*` → UI, navigation, DI, viewmodels
- `app/src/main/java/com/dgnotes/domain/*` → models, repositories, use cases
- `app/src/main/java/com/dgnotes/data/*` → Supabase client and repository implementation


## Why GitHub Pages link will not run this app
This is an Android app project, not a web app. A GitHub Pages URL cannot execute Android code.

## Run locally (step-by-step)
1. Install Android Studio (latest stable).
2. Open this repository folder as a project.
3. Ensure JDK 17 is selected in **Gradle JDK**.
4. Add your Supabase values in `gradle.properties`:
   - `SUPABASE_URL`
   - `SUPABASE_ANON_KEY`
5. Create/update your Supabase table and add `user_id` column + RLS policies.
6. Sync Gradle.
7. Run on emulator/device using `app` run configuration.

If you get auth/empty-notes issues, verify the signed-in user exists and table `user_id` matches `auth.users.id`.
