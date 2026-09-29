package com.example.loginscreen;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.loginscreen.databinding.FragmentSecondBinding;
import com.google.android.material.snackbar.Snackbar;

public class secondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        // Login text -> go back
        binding.tvLogin.setOnClickListener(v ->
                Navigation.findNavController(v).popBackStack()
        );

        // Click outside input fields -> hide keyboard
        binding.RegisterLayout.setOnClickListener(v -> {
            hideKeyboard();
        });

        // Register button
        binding.BLogin.setOnClickListener(v -> {

            hideKeyboard();

            String message = "";

            message += "Email: "
                    + binding.TEditEmail.getText().toString();

            message += "\nUsername: "
                    + binding.TEditUsername.getText().toString();

            message += "\nPassword: "
                    + binding.TEditPassword.getText().toString();

            message += "\nConfirm Password: "
                    + binding.TEditCfPassword.getText().toString();

            Snackbar.make(
                    binding.getRoot(),
                    message,
                    Snackbar.LENGTH_INDEFINITE
            ).setAction("OK", view -> {

            }).show();
        });

        // Listen for text changes
        addTextInputListener();

        // Check button when Fragment starts
        validateButtonSubmit();

        return binding.getRoot();
    }


    // Enable/disable Register button
    private void validateButtonSubmit() {

        if (binding.TEditEmail.getText().toString().isEmpty()
                || binding.TEditUsername.getText().toString().isEmpty()
                || binding.TEditPassword.getText().toString().isEmpty()
                || binding.TEditCfPassword.getText().toString().isEmpty()) {

            binding.BLogin.setEnabled(false);

        } else {

            binding.BLogin.setEnabled(true);
        }
    }


    // Watch all input fields
    private void addTextInputListener() {

        TextWatcher handleTextChange = new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing here
            }

            @Override
            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after) {
                // Nothing here
            }

            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count) {

                validateButtonSubmit();
            }
        };

        binding.TEditEmail.addTextChangedListener(handleTextChange);
        binding.TEditUsername.addTextChangedListener(handleTextChange);
        binding.TEditPassword.addTextChangedListener(handleTextChange);
        binding.TEditCfPassword.addTextChangedListener(handleTextChange);
    }


    // Hide keyboard
    private void hideKeyboard() {

        View view = requireActivity().getCurrentFocus();

        if (view == null) {
            view = new View(requireContext());
        }

        InputMethodManager imm =
                (InputMethodManager) requireContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm != null) {
            imm.hideSoftInputFromWindow(
                    view.getWindowToken(),
                    0
            );
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}