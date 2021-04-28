# Generated by Django 3.1.5 on 2021-02-01 02:30

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('cfuser', '0001_initial'),
        ('cfboard', '0004_auto_20210126_2228'),
    ]

    operations = [
        migrations.CreateModel(
            name='Boardcomment',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('contents', models.TextField(verbose_name='내용')),
                ('board', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='cfboard.cfboard', verbose_name='보드')),
                ('writer', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='cfuser.cfuser', verbose_name='작성자')),
            ],
            options={
                'verbose_name': '댓글',
                'verbose_name_plural': '댓글',
                'db_table': 'board comment',
            },
        ),
    ]